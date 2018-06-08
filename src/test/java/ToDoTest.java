import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.Priority;
import de.swtproject.doit.core.ToDo;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class ToDoTest {

    private ToDo todo;

    @org.junit.Before
    public void beforeEach() throws SQLException {
        todo = ToDo.create("task");
        DatabaseManager.storeToDo(todo);
    }

    @After
    public void after() throws SQLException {
        DatabaseManager.phoenix();
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

    @Test
    public void priorityTest() {
        ToDo task = ToDo.create("Test");
        assertEquals(Priority.DEFAULT.name, task.getPriority().name);

        task.setPriority(Priority.URGENT);
        assertEquals(Priority.URGENT.name, task.getPriority().name);
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

    @org.junit.Test
    public void serializeTest() {
        JSONObject ds = todo.serialize();
        assertEquals( todo.getTitle(), ds.get("title") );
        if (ds.has("description")) assertEquals( todo.getDescription(), ds.get("description"));
        if (ds.has("interval")) assertEquals( todo.getInterval().toString(), ds.get("interval"));
        if (ds.has("priority")) assertEquals( todo.getPriority().toString(), ds.get("priority"));
    }

    @org.junit.Test
    public void notifyTest() {
        ToDo task = ToDo.create("Test");
        assertFalse(task.isNotified());

        task.setNotified(true);
        assertTrue(task.isNotified());
    }
}
