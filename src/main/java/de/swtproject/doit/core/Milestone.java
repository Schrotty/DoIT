package de.swtproject.doit.core;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Milestone
 */
@DatabaseTable(tableName = "milestone")
public class Milestone {

    public final static String ID_FIELD_NAME = "id";

    /**
     * The Id.
     */
    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    /**
     * The Title.
     */
    @DatabaseField
    private String title;

    /**
     * The Description.
     */
    @DatabaseField()
    private String description;



    /**
     * The Start.
     */
    @DatabaseField()
    private Date start;

    /**
     * The Deadline.
     */
    @DatabaseField()
    private Date deadline;

    /**
     * Assigned todos
     */
    private List<ToDo> assignedToDos;


    /**
     * Instantiates a new To do.
     */
    Milestone() {
        //needed for ORMLight
    }

    /**
     * Instantiates a new To do.
     *
     * @param title the title
     */
    public Milestone(String title) {
        this.title = title;
        this.assignedToDos = new LinkedList<>();
    }

    /**
     * Get the id of the milestone
     * @return milestoneid
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Create a new {@link Milestone} with given title.
     *
     * @param title the given title
     * @return the created TODOGUI
     */
    public static Milestone create(String title) {
        return new Milestone(title);
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Get the assigned ToDos
     * @return assigned todos
     */
    public List<ToDo> getAssignedToDos() {
        return assignedToDos;
    }

    /**
     * Set assigned Todos
     * @param assigned todos to be set
     */
    public void setAssignedToDos(List<ToDo> todos) {
        this.assignedToDos = todos;
    }

    /**
     * Gets start.
     *
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * Sets start.
     *
     * @param start the start
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Gets deadline.
     *
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * Sets deadline.
     *
     * @param deadline the deadline
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }


    /**
     * Finish a todo.
     *
     * @return finishing successful?
     * @throws SQLException on SQL excetion
     */
    public boolean finish() throws SQLException {

        return update();
    }

    /**
     * Delete a todo.
     *
     * @return deleting successful?
     * @throws SQLException on SQL exception
     */
    public boolean delete() throws SQLException {
        return DatabaseManager.getInstance().deleteMilestone(this);
    }

    /**
     * Update todo.
     *
     * @return updating successful?
     * @throws SQLException on SQL exception
     */
    public boolean update() throws SQLException {
        return DatabaseManager.updateMilestone(this);
    }

    /**
     * Get the string repro.
     *
     * @return updating successful?
     */
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Milestone))
            return false;

        return this.id == ((Milestone) other).id;
    }
}
