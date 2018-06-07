import de.swtproject.doit.core.*;
import org.junit.After;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class MilestoneTest {

    private Milestone milestone;

    @org.junit.Before
    public void beforeEach() throws SQLException {
        DatabaseManager.phoenix();
        milestone = Milestone.create("milestone");
        DatabaseManager.storeMilestone(milestone);
    }

    @After
    public void after() throws SQLException {
        DatabaseManager.phoenix();
    }

    @Test
    public void titleTest() {
        milestone.setTitle("test");
        assertEquals("test", milestone.getTitle());
    }

    @Test
    public void descriptionTest() {
        milestone.setDescription("test");
        assertEquals("test", milestone.getDescription());
    }

    @Test
    public void startDateTest() {
        Date d = new Date();

        milestone.setStart(d);
        assertEquals(d, milestone.getStart());
    }

    @Test
    public void deadlineTest() {
        Date d = new Date();

        milestone.setDeadline(d);
        assertEquals(d, milestone.getDeadline());
    }

    @Test
    public void deleteTest() throws SQLException {
        assertTrue(milestone.delete());
        assertEquals(DatabaseManager.getAllMilestones(true).size(), 0);
    }

    @Test
    public void setToDos() throws SQLException {
        ToDo t = ToDo.create("hallo");
        ToDo t2 = ToDo.create("hallo");
        List<ToDo> l = new LinkedList<>();
        l.add(t);
        l.add(t2);

        milestone.setAssignedToDos(l);

        assertEquals(milestone.getAssignedToDos(), l);

    }

    @org.junit.Test
    public void equal() throws SQLException
    {
        List<Milestone> milestones = DatabaseManager.getAllMilestones(false);
        assertEquals(1, milestones.size());
        assertTrue(milestones.get(0).equals(milestone));

        assertNotEquals(milestones, milestone);


    }

    @Test
    public void toStringTest() {
        assertEquals("milestone", milestone.toString());
    }
}
