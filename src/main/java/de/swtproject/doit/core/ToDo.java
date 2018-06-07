package de.swtproject.doit.core;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The type To do.
 */
@DatabaseTable(tableName = "todo")
public class ToDo {

    // query field-name
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
     * The Interval.
     */
    @DatabaseField(dataType = DataType.ENUM_INTEGER)
    private IntervalType interval;

    /**
     * The Production.
     */
    @DatabaseField(defaultValue = "true")
    private Boolean production;

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
     * The Notify point.
     */
    @DatabaseField()
    private Date notifyPoint;



    /**
     * The priority.
     */
    @DatabaseField()
    private Priority priority;

    /**
     * Instantiates a new To do.
     */
    ToDo() {
        //needed for ORMLight
    }

    /**
     * Instantiates a new To do.
     *
     * @param title the title
     */
    public ToDo(String title) {
        this.title = title;
        this.priority = Priority.DEFAULT;
    }

    /**
     * Create a new {@link ToDo} with given title.
     *
     * @param title the given title
     * @return the created TODOGUI
     */
    public static ToDo create(String title) {
        return new ToDo(title);
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
     * Gets interval.
     *
     * @return the interval
     */
    public IntervalType getInterval() {
        return interval;
    }

    /**
     * Sets interval.
     *
     * @param interval the interval
     */
    public void setInterval(IntervalType interval) {
        this.interval = interval;
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
     * Gets notify point.
     *
     * @return the notify point
     */
    public Date getNotifyPoint() {
        return notifyPoint;
    }

    /**
     * Get the database id
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets notify point.
     *
     * @param notifyPoint the notify point
     */
    public void setNotifyPoint(Date notifyPoint) {
        this.notifyPoint = notifyPoint;
    }

    /**
     * Get the priority.
     *
     * @return the priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets the priority.
     *
     * @param priority the priority
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Finish a todo.
     *
     * @return finishing successful?
     * @throws SQLException on SQL excetion
     */
    public boolean finish() throws SQLException {
        production = false;
        return update();
    }

    /**
     * Delete a todo.
     *
     * @return deleting successful?
     * @throws SQLException on SQL exception
     */
    public boolean delete() throws SQLException {
        return DatabaseManager.getInstance().deleteToDo(this);
    }

    /**
     * Update todo.
     *
     * @return updating successful?
     * @throws SQLException on SQL exception
     */
    private boolean update() throws SQLException {
        return DatabaseManager.getInstance().todoAccess.update(this) == 1;
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
        if (!(other instanceof ToDo))
            return false;

        return this.id == ((ToDo) other).id;
    }
}
