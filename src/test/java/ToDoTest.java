import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.ToDo;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ToDoTest {

    private ToDo todo;

    @org.junit.Before
    public void beforeEach() throws SQLException {
        todo = ToDo.create("task");
        DatabaseManager.storeToDo(todo);
    }

    @org.junit.Test
    public void titleTest() {
        todo.setTitle("test");
        assertEquals("test", todo.getTitle());
    }

    @org.junit.Test
    public void descriptionTest() {
        todo.setDescription("test");
        assertEquals("test", todo.getDescription());
    }

    @org.junit.Test
    public void intervalTest() {
        todo.setInterval(IntervalType.DAILY);
        assertEquals(IntervalType.DAILY, todo.getInterval());
    }

    @org.junit.Test
    public void startDateTest() {
        Date d = new Date();

        todo.setStart(d);
        assertEquals(d, todo.getStart());
    }

    @org.junit.Test
    public void deadlineTest() {
        Date d = new Date();

        todo.setDeadline(d);
        assertEquals(d, todo.getDeadline());
    }

    @org.junit.Test
    public void notifyPointTest() {
        Date d = new Date();

        todo.setNotifyPoint(d);
        assertEquals(d, todo.getNotifyPoint());
    }

    @org.junit.Test
    public void finishTest() throws SQLException {
        assertTrue(todo.finish());
    }

    @org.junit.Test
    public void deleteTest() throws SQLException {
        assertTrue(todo.delete());
    }

    @org.junit.Test
    public void toStringTest() {
        assertEquals("task", todo.toString());
    }
}