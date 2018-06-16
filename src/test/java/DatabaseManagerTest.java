import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.Milestone;
import de.swtproject.doit.core.ToDo;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the DatabaseManager.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 1.0
 */
public class DatabaseManagerTest {

    @org.junit.BeforeClass
    public static void before() throws SQLException {
        DatabaseManager.phoenix();
    }

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

    @org.junit.Test
    public void getNotNotifiedTasks() throws SQLException {
        ToDo example = ToDo.create("Schrotty");
        DatabaseManager.storeToDo(example);

        assertFalse(DatabaseManager.getNotNotifiedTasks().isEmpty());

        example.setNotified(true);
        example.update();

        assertTrue(DatabaseManager.getNotNotifiedTasks().isEmpty());
    }

    public void storeMilestone() throws Exception {
        Milestone m = Milestone.create("Testmilestone");

        assertEquals(m.getTitle(), DatabaseManager.storeMilestone(m).getTitle());

        List<ToDo> ts = new LinkedList<>();

        ts.add(DatabaseManager.storeToDo(ToDo.create("peterfraggin")));
        ts.add(DatabaseManager.storeToDo(ToDo.create("glennfragmire")));

        Milestone m2 = Milestone.create("Testmilestone2");

        m2.setAssignedToDos(ts);

        assertEquals(m2.getTitle(), DatabaseManager.storeMilestone(m2).getTitle());


    }

    @org.junit.Test
    public void getSingleMilestone_getToDosForMilestone() throws SQLException {

        Milestone m = DatabaseManager.storeMilestone(Milestone.create("Testmilestone"));

        assertEquals(m.getId(), DatabaseManager.getSingleMilestone(m.getId(), false).getId());

        List<ToDo> ts = new LinkedList<>();

        ts.add(DatabaseManager.storeToDo(ToDo.create("peterpan")));
        ts.add(DatabaseManager.storeToDo(ToDo.create("ichtestenichtgerne")));

        Milestone m2 = Milestone.create("Testmilestone2");
        m2.setAssignedToDos(ts);

        DatabaseManager.storeMilestone(m2);

        List<ToDo> toDos = DatabaseManager.getSingleMilestone(m2.getId(), true).getAssignedToDos();

        assertEquals(toDos.size(), ts.size());

        for(ToDo t : toDos)
        {
            assertTrue(ts.contains(t));
        }


    }

    @org.junit.Test
    public void updateMilestone() throws SQLException {

        List<ToDo> ts = new LinkedList<>();

        ToDo toRemove = DatabaseManager.storeToDo(ToDo.create("banana"));

        ts.add(toRemove);
        ts.add(DatabaseManager.storeToDo(ToDo.create("mango")));

        Milestone m = Milestone.create("8mile");
        m.setAssignedToDos(ts);

        DatabaseManager.storeMilestone(m);

        ts.add(DatabaseManager.storeToDo(ToDo.create("apfel")));

        ts.remove(toRemove);

        m.setAssignedToDos(ts);

        String oldT = m.getTitle();
        String oldD = m.getDescription();

        m.setDescription("neu");
        m.setTitle("titleeeeee");

        m.update();

        Milestone dbMilestone =  DatabaseManager.getSingleMilestone(m.getId(), true);

        List<ToDo> toDos = dbMilestone.getAssignedToDos();
        
        assertEquals(m.getId(), dbMilestone.getId());
        assertNotEquals(m.getTitle(), oldT);
        assertNotEquals(m.getDescription(), oldD);
        assertEquals(toDos.size(), ts.size());

        for(ToDo t : toDos)
        {
            assertTrue(ts.contains(t));
        }
    }
    @org.junit.Test
    public void deleteMilestone() throws SQLException
    {
        List<ToDo> ts = new LinkedList<>();

        ts.add(DatabaseManager.storeToDo(ToDo.create("bernd")));
        ts.add(DatabaseManager.storeToDo(ToDo.create("brot")));

        Milestone m = Milestone.create("bockwurstpresse");
        m.setAssignedToDos(ts);

        m = DatabaseManager.storeMilestone(m);

        assertTrue(m.delete());
    }

    @org.junit.Test
    public void deleteToDo() throws SQLException
    {
        List<ToDo> ts = new LinkedList<>();

        ToDo td = DatabaseManager.storeToDo(ToDo.create("bernd"));

        ts.add(td);
        ts.add(DatabaseManager.storeToDo(ToDo.create("brot")));

        Milestone m = Milestone.create("bockwurstpresse");
        m.setAssignedToDos(ts);

        m = DatabaseManager.storeMilestone(m);

        assertTrue(td.delete());
    }

    @org.junit.Test
    public void getAllMilestones() throws SQLException {

        List<ToDo> ts = new LinkedList<>();

        ToDo toAdd = DatabaseManager.storeToDo(ToDo.create("banana"));

        ts.add(toAdd);

        Milestone m = Milestone.create("kiwi");
        m.setAssignedToDos(ts);

        m = DatabaseManager.storeMilestone(m);
        Milestone m2 = DatabaseManager.storeMilestone(Milestone.create("nix"));

        List<Milestone> milestones = DatabaseManager.getAllMilestones(true);

        assertEquals(milestones.size(), 2);

        boolean found = false;

        for(Milestone tm : milestones)
        {
            if(tm.getAssignedToDos().size() > 0)
            {
                assertEquals(m.getAssignedToDos(), tm.getAssignedToDos());
                found = true;
            }

        }

        assertTrue(found);

    }
}