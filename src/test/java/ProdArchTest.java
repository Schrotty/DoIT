import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.ToDo;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProdArchTest {

    private ToDo todo;
    private ToDo todo2;
    private ToDo todo3;

    @Before
    public void beforeEach() throws SQLException {
        DatabaseManager.phoenix();

        todo = ToDo.create("task");
        DatabaseManager.storeToDo(todo);

        todo2 = ToDo.create("task 2");
        DatabaseManager.storeToDo(todo2);

        todo3 = ToDo.create("task 3");
        DatabaseManager.storeToDo(todo3);

    }

    @Test
    public void lengthTest() throws SQLException{
        assertEquals(3, DatabaseManager.getCollection(true).size());
    }


    @Test
    public void finishTest() throws SQLException {
        todo.finish();
        assertEquals(2, DatabaseManager.getCollection(true).size());
        assertEquals(1, DatabaseManager.getCollection(false).size());
    }

    @Test
    public void deleteTest() throws SQLException {
        todo2.finish();
        todo3.finish();
        todo2.delete();
        assertEquals(1, DatabaseManager.getCollection(true).size());
        assertEquals(1, DatabaseManager.getCollection(false).size());
    }
}
