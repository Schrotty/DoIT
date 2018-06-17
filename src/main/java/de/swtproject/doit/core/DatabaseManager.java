package de.swtproject.doit.core;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import de.swtproject.doit.util.Settings;

import java.io.File;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Manager controller for accessing the database.
 * Used to store and receive objects from the databasse.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.1
 */
public class DatabaseManager {

    /**
     * DatabaseManager singleton.
     */
    private static DatabaseManager self = new DatabaseManager();

    /**
     * The database access object (ToDo) used by the manager.
     */
    Dao<ToDo, Integer> todoAccess;

    /**
     * The database access object (Milestone) used by the manager.
     */
    Dao<Milestone, Integer> milestoneAccess;

    /**
     * The database access object (MilestoneToDo) used by the manager.
     */
    Dao<MilestoneToDo, Integer> milestoneToDoAccess;

    /**
     * The connection source used by the manager.
     */
    private ConnectionSource connectionSource;

    /**
     * Constructor for a new DatabaseManager
     */
    private DatabaseManager() {
        try {
            createDataDirIfMissing(); //see ya in /dev/null for that name...

            connectionSource = new JdbcConnectionSource(Settings.getConnectionString().intern());
            todoAccess = DaoManager.createDao(connectionSource, ToDo.class);
            milestoneAccess = DaoManager.createDao(connectionSource, Milestone.class);
            milestoneToDoAccess = DaoManager.createDao(connectionSource, MilestoneToDo.class);

            //create needed tables
            TableUtils.createTableIfNotExists(connectionSource, ToDo.class);
            TableUtils.createTableIfNotExists(connectionSource, Milestone.class);
            TableUtils.createTableIfNotExists(connectionSource, MilestoneToDo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Get DatabaseManager instance.
     *
     * @return the instance
     */
    public static DatabaseManager getInstance() {
        return self;
    }

    /**
     * Clear all tables in database.
     *
     * @throws SQLException if exception is thrown
     */
    public static void phoenix() throws SQLException {
        //drop all tables
        TableUtils.dropTable(self.connectionSource, ToDo.class, true);
        TableUtils.dropTable(self.connectionSource, Milestone.class, true);
        TableUtils.dropTable(self.connectionSource, MilestoneToDo.class, true);
        //re-create all tables with fresh indices
        TableUtils.createTableIfNotExists(self.connectionSource, ToDo.class);
        TableUtils.createTableIfNotExists(self.connectionSource, Milestone.class);
        TableUtils.createTableIfNotExists(self.connectionSource, MilestoneToDo.class);
    }

    /**
     * Save a single object.
     *
     * @param todo the object to save
     * @return the to do
     * @throws SQLException on SQL exception
     */
    public static ToDo storeToDo(ToDo todo) throws SQLException {
        return self.todoAccess.createIfNotExists(todo);
    }

    /**
     * Save a milestone object
     * @param milestone
     * @return the milestone
     * @throws SQLException
     */
    public static Milestone storeMilestone(Milestone milestone) throws SQLException {
        Milestone createdMilestone = self.milestoneAccess.createIfNotExists(milestone);


        updateMilestone(createdMilestone);


        return milestone;
    }

    /**
     * Update a milestone
     * @param milestone
     * @return success?
     * @throws SQLException
     */
    public static boolean updateMilestone(Milestone milestone) throws SQLException {


        if(milestone != null)
        {
            List<MilestoneToDo> currentAssignedToDos = getmilestoneToDosByMilestone(milestone.getId());
            List<ToDo> todosToAdd =  milestone.getAssignedToDos();

            for(ToDo t : todosToAdd)
                storeMilestoneToDo(MilestoneToDo.create(t, milestone));

            List<MilestoneToDo> filtered =  currentAssignedToDos.stream().filter(x -> !todosToAdd.contains(x.todo)).collect(Collectors.toList());

            for(MilestoneToDo t :  filtered)
                t.delete();


        }

        return  getInstance().milestoneAccess.update(milestone) == 1;
    }

    /**
     * Delete a milestone
     * @param milestone
     * @return success?
     * @throws SQLException
     */
    public static boolean deleteMilestone(Milestone milestone) throws SQLException
    {
        // take care of assigned todo mappings

        List<MilestoneToDo> data = getmilestoneToDosByMilestone(milestone.getId());

        for(MilestoneToDo t : data)
            t.delete();


        return self.milestoneAccess.delete(milestone) == 1;
    }

    /**
     * Deletes a ToDo
     * @param todo
     * @return
     * @throws SQLException
     */
    public static boolean deleteToDo(ToDo todo) throws SQLException
    {
        // take care of assigned milstone mappings

        List<MilestoneToDo> data = getmilestoneToDosByToDo(todo.getId());

        for(MilestoneToDo t : data)
        {
            t.delete();
        }

        return self.todoAccess.delete(todo) == 1;
    }

    /**
     * Save a milestonetodo object
     * @param milestoneToDo
     * @return the milestonetodo
     * @throws SQLException
     */
    private static MilestoneToDo storeMilestoneToDo(MilestoneToDo milestoneToDo) throws SQLException {
        return self.milestoneToDoAccess.createIfNotExists(milestoneToDo);
    }


    /**
     * Get mappings for milestone
     * @param milestoneID
     * @return milestone mappings
     * @throws SQLException
     */
    private static List<MilestoneToDo> getmilestoneToDosByMilestone(int milestoneID) throws SQLException {
        QueryBuilder<MilestoneToDo, Integer> queryBuilder = self.milestoneToDoAccess.queryBuilder();
        Where<MilestoneToDo, Integer> where = queryBuilder.where();

        where.eq(MilestoneToDo.MILESTONE_ID_FIELD_NAME, milestoneID);
        PreparedQuery<MilestoneToDo> preparedQuery = queryBuilder.prepare();

        return self.milestoneToDoAccess.query(preparedQuery);
    }

    /**
     * Get mapping for Todos
     * @param toDoID
     * @return todo mappings
     * @throws SQLException
     */
    private static List<MilestoneToDo> getmilestoneToDosByToDo(int toDoID) throws SQLException {
        QueryBuilder<MilestoneToDo, Integer> queryBuilder = self.milestoneToDoAccess.queryBuilder();
        Where<MilestoneToDo, Integer> where = queryBuilder.where();

        where.eq(MilestoneToDo.TODO_ID_FIELD_NAME, toDoID);
        PreparedQuery<MilestoneToDo> preparedQuery = queryBuilder.prepare();

        return self.milestoneToDoAccess.query(preparedQuery);
    }


    /**
     * Get todos assigned to a milestone
     * @param milestoneID
     * @return todos
     * @throws SQLException
     */
    public static List<ToDo> getToDoForMilestone(Milestone milestone) throws SQLException {

        QueryBuilder<MilestoneToDo, Integer> milestoneToDoQb = self.milestoneToDoAccess.queryBuilder();

        milestoneToDoQb.selectColumns(MilestoneToDo.TODO_ID_FIELD_NAME);
        SelectArg userSelectArg = new SelectArg();

        milestoneToDoQb.where().eq(MilestoneToDo.MILESTONE_ID_FIELD_NAME, userSelectArg);

        QueryBuilder<ToDo, Integer> todoQb = self.todoAccess.queryBuilder();

        todoQb.where().in(ToDo.ID_FIELD_NAME, milestoneToDoQb);


        PreparedQuery<ToDo> q = todoQb.prepare();
        q.setArgumentHolderValue(0, milestone);
        return self.todoAccess.query(q);
    }

    /**
     * Get list of a miilestone with all
     * @param withToDos append all todos?
     * @return all milestones
     * @throws SQLException
     */
    public static List<Milestone> getAllMilestones(boolean withToDos) throws SQLException {
        QueryBuilder<Milestone, Integer> queryBuilder = self.milestoneAccess.queryBuilder();

        PreparedQuery<Milestone> preparedQuery = queryBuilder.prepare();

        List<Milestone> ret = self.milestoneAccess.query(preparedQuery);

        if(withToDos)
            for(Milestone m : ret)
                m.setAssignedToDos(getToDoForMilestone(m));

        return ret;
    }

    /**
     * Get a single milestone
     * @param id milstone id
     * @param withTodos apend todos?
     * @return the milestone
     * @throws SQLException
     */
    public static Milestone getSingleMilestone(int id, boolean withTodos) throws SQLException {

        if(withTodos)
        {
            Milestone ret = self.milestoneAccess.queryForId(id);
            ret.setAssignedToDos(getToDoForMilestone(ret));
            return ret;
        }
        else
        {
            return self.milestoneAccess.queryForId(id);
        }

    }

    /**
     * Load a single object from the database.
     *
     * @param id the string to query with
     * @return the loaded object
     * @throws SQLException on SQL exception
     */
    public static ToDo getSingleToDo(int id) throws SQLException {
        return self.todoAccess.queryForId(id);
    }

    /**
     * Get a collection of {@link ToDo}s.
     *
     * @param loadProduction load production todo's
     * @return the todo collection
     * @throws SQLException on SQL exception
     */
    public static List<ToDo> getCollection(boolean loadProduction) throws SQLException {
        QueryBuilder<ToDo, Integer> queryBuilder = self.todoAccess.queryBuilder();
        Where<ToDo, Integer> where = queryBuilder.where();
        SelectArg selectArg = new SelectArg();

        where.eq("production", selectArg);
        PreparedQuery<ToDo> preparedQuery = queryBuilder.prepare();

        selectArg.setValue(loadProduction);
        List<ToDo> todos = self.todoAccess.query(preparedQuery);

        todos.sort((o1, o2) -> Integer.compare(o2.getPriority().getWeight(), o1.getPriority().getWeight()));

        return todos;
    }

    /**
     * Get a collection of {@link ToDo}s which are
     * not yet notified.
     *
     * @return the todo collection
     * @throws SQLException on SQL exception
     */
    public static List<ToDo> getNotNotifiedTasks() throws SQLException {
        List<ToDo> list = getCollection(true);
        list.removeIf(ToDo::isNotified);

        return list;
    }

    /**
     * @deprecated
     *
     * Use Settings.createDataDirIfMissing()
     *
     * Create the data directory if it's missing
     *
     * @throws IllegalStateException the illegal state exception
     */
    @Deprecated
    private void createDataDirIfMissing() throws IllegalStateException {
        Settings.createDataDirIfMissing();
    }
}