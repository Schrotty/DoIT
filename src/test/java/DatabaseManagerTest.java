import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.ToDo;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the DatabaseManager.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 1.0
 */
public class DatabaseManagerTest {

    @org.junit.After
    public void tearDown() throws SQLException {
        DatabaseManager.phoenix();
    }

    @org.junit.Test
    public void storeToDo() throws Exception {
        ToDo example = ToDo.create("Schrotty");
        assertEquals(example.getTitle(), DatabaseManager.storeToDo(example).getTitle());
    }

    @org.junit.Test
    public void getSingleToDo() throws SQLException {
        ToDo example = ToDo.create("Schrotty");
        DatabaseManager.storeToDo(example);

        assertEquals(example.getTitle(), DatabaseManager.getSingleToDo(1).getTitle());
    }

    @org.junit.Test
    public void getCollection() throws SQLException {
        DatabaseManager.storeToDo(ToDo.create("Schrotty")).finish();

        assertTrue(DatabaseManager.getCollection(true).isEmpty());
    }
}