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
    Dao<ToDo, String> todoAccess;

    /**
     * The database access object (Milestone) used by the manager.
     */
    Dao<Milestone, String> milestoneAccess;

    /**
     * The database access object (MilestoneToDo) used by the manager.
     */
    Dao<MilestoneToDo, String> milestoneToDoAccess;

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

        boolean[] error = new boolean[1];
        error[0] = false;

        if(milestone != null)
        {
            List<MilestoneToDo> currentAssignedToDos = getmilestoneToDos(milestone.getId());
            List<ToDo> todosToAdd =  milestone.getAssignedToDos();
            todosToAdd.stream().forEach(x -> {
                try {
                    storeMilestoneToDo(MilestoneToDo.create(x, milestone));
                } catch (SQLException e) {
                    error[0] = true;
                    e.printStackTrace();
                }
            });

            currentAssignedToDos.stream().filter(x -> !todosToAdd.contains(x)).forEach(x -> {
                try {
                    x.delete();
                } catch (SQLException e) {
                    error[0] = true;
                    e.printStackTrace();
                }
            });


        }

        return getInstance().milestoneAccess.update(milestone) == 1 && !error[0];
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



    private static List<MilestoneToDo> getmilestoneToDos(int milestoneID) throws SQLException {
        QueryBuilder<MilestoneToDo, String> queryBuilder = self.milestoneToDoAccess.queryBuilder();
        Where<MilestoneToDo, String> where = queryBuilder.where();

        where.eq(MilestoneToDo.MILESTONE_ID_FIELD_NAME, milestoneID);
        PreparedQuery<MilestoneToDo> preparedQuery = queryBuilder.prepare();

        return self.milestoneToDoAccess.query(preparedQuery);
    }

    public static List<ToDo> getToDoForMilestone(int milestoneID) throws SQLException {
        QueryBuilder<MilestoneToDo, String> queryBuilder = self.milestoneToDoAccess.queryBuilder();
        Where<MilestoneToDo, String> where = queryBuilder.where();

        where.eq(MilestoneToDo.MILESTONE_ID_FIELD_NAME, milestoneID);
        PreparedQuery<MilestoneToDo> preparedQuery = queryBuilder.prepare();

        List<ToDo> ret = new LinkedList<>();

        for(MilestoneToDo m : self.milestoneToDoAccess.query(preparedQuery))
            ret.add(m.todo);

        return ret;
    }

    public static List<Milestone> getCollection(int milestoneID, boolean withToDos) throws SQLException {
        QueryBuilder<Milestone, String> queryBuilder = self.milestoneAccess.queryBuilder();
        Where<Milestone, String> where = queryBuilder.where();

        where.eq(Milestone.ID_FIELD_NAME, milestoneID);
        PreparedQuery<Milestone> preparedQuery = queryBuilder.prepare();

        List<Milestone> ret = self.milestoneAccess.query(preparedQuery);

        if(withToDos)
            for(Milestone m : ret)
                m.setAssignedToDos(getToDoForMilestone(milestoneID));

        return ret;
    }

    public static Milestone getSingleMilestone(int id, boolean withTodos) throws SQLException {

        if(withTodos)
        {
            Milestone ret = self.milestoneAccess.queryForId(Integer.toString(id));
            ret.setAssignedToDos(getToDoForMilestone(id));
            return ret;
        }
        else
        {
            return self.milestoneAccess.queryForId(Integer.toString(id));
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
        return self.todoAccess.queryForId(Integer.toString(id));
    }

    /**
     * Get a collection of {@link ToDo}s.
     *
     * @param loadProduction load production todo's
     * @return the todo collection
     * @throws SQLException on SQL exception
     */
    public static List<ToDo> getCollection(boolean loadProduction) throws SQLException {
        QueryBuilder<ToDo, String> queryBuilder = self.todoAccess.queryBuilder();
        Where<ToDo, String> where = queryBuilder.where();
        SelectArg selectArg = new SelectArg();

        where.eq("production", selectArg);
        PreparedQuery<ToDo> preparedQuery = queryBuilder.prepare();

        selectArg.setValue(loadProduction);
        List<ToDo> todos = self.todoAccess.query(preparedQuery);

        todos.sort((o1, o2) -> Integer.compare(o2.getPriority().weight, o1.getPriority().weight));

        return todos;
    }

    /**
     * Create the data directory if it's missing
     *
     * @throws IllegalStateException the illegal state exception
     */
    private void createDataDirIfMissing() throws IllegalStateException {
        File directory = new File(Settings.getDataDir());
        if (!directory.exists()) {
            if (!directory.mkdir()) throw new IllegalStateException("data directory not created!");
        }
    }
}