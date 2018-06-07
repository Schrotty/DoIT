package de.swtproject.doit.core;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Date;

/**
 * The type To do.
 */
@DatabaseTable(tableName = "todoMilestone")
public class MilestoneToDo {

    public final static String MILESTONE_ID_FIELD_NAME = "milestone_id";
    public final static String TODO_ID_FIELD_NAME = "todo_id";

    /**
     * The Id.
     */
    @DatabaseField(generatedId = true)
    private int id;

    // foreign milestone todo
    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false, columnName = TODO_ID_FIELD_NAME)
    ToDo todo;

    // foreign milestone
    @DatabaseField(foreign = true, foreignAutoRefresh = true, canBeNull = false, columnName = MILESTONE_ID_FIELD_NAME)
    Milestone milestone;


    /**
     * Instantiates a new To do.
     */
    MilestoneToDo() {
        //needed for ORMLight
    }


    /**
     * Create a new {@link MilestoneToDo} with given title.
     *
     * @param todo      the given todo
     * @param milestone the given milestone
     * @return the created milestone
     */
    public static MilestoneToDo create(ToDo todo, Milestone milestone) {
        return new MilestoneToDo(todo, milestone);
    }

    /**
     * Instantiates a new MilestoneToDo.
     *
     * @param todo      the todo
     * @param milestone the milestone
     */
    public MilestoneToDo(ToDo todo, Milestone milestone) {
        this.milestone = milestone;
        this.todo = todo;
    }

    /**
     * Delete a MilestoneToDo.
     *
     * @return deleting successful?
     * @throws SQLException on SQL exception
     */
    public boolean delete() throws SQLException {
        return DatabaseManager.getInstance().milestoneToDoAccess.delete(this) == 1;
    }





}