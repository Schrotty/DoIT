import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.NotificationPoint;
import de.swtproject.doit.core.ToDo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class NotifyPointTest {

    @Test
    public void create1() {
        NotificationPoint p = NotificationPoint.create("Days", Calendar.DAY_OF_YEAR);

        assertEquals("Days", p.getDisplayName());
        assertEquals(Calendar.DAY_OF_YEAR, p.getCalenderType());
        assertEquals(0, p.getValue());
        assertEquals(0, p.getRawValue());
        assertEquals("Days", p.toString());
    }

    @Test
    public void create2() {
        NotificationPoint p = NotificationPoint.create("Weeks", String.valueOf(Calendar.DAY_OF_YEAR), "1");

        assertEquals("Weeks", p.getDisplayName());
        assertEquals(Calendar.DAY_OF_YEAR, p.getCalenderType());
        assertEquals(-1, p.getValue());
        assertEquals(1, p.getRawValue());
        assertEquals("Weeks", p.toString());
    }

    @Test
    public void create3() {
        NotificationPoint p = NotificationPoint.create(NotificationPoint.create("Months", String.valueOf(Calendar.DAY_OF_YEAR), "1"), "5");

        assertEquals("Months", p.getDisplayName());
        assertEquals(Calendar.DAY_OF_YEAR, p.getCalenderType());
        assertEquals(-5, p.getValue());
        assertEquals(5, p.getRawValue());
        assertEquals("Months", p.toString());
    }

    @Test
    public void hourNotifyType() throws SQLException {
        NotificationPoint p = NotificationPoint.create("Days", String.valueOf(Calendar.HOUR_OF_DAY), "1");

        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(p.getCalenderType(), p.getValue());

                Calendar c = Calendar.getInstance();
                c.roll(Calendar.HOUR_OF_DAY, -1);

                assertEquals(c.getTime().getDay(), calendar.getTime().getDay());
            }
        }
    }

    @Test
    public void dailyNotifyType() throws SQLException {
        NotificationPoint p = NotificationPoint.create("Days", String.valueOf(Calendar.DAY_OF_YEAR), "1");

        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(p.getCalenderType(), p.getValue());

                Calendar c = Calendar.getInstance();
                c.roll(Calendar.DAY_OF_YEAR, -1);

                assertEquals(c.getTime().getDay(), calendar.getTime().getDay());
            }
        }
    }

    @Test
    public void weekNotifyType() throws SQLException {
        NotificationPoint p = NotificationPoint.create("Days", String.valueOf(Calendar.WEEK_OF_YEAR), "1");

        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(p.getCalenderType(), p.getValue());

                Calendar c = Calendar.getInstance();
                c.roll(Calendar.WEEK_OF_YEAR, -1);

                assertEquals(c.getTime().getMonth(), calendar.getTime().getMonth());
            }
        }
    }

    @Test
    public void monthlyNotifyType() throws SQLException {
        NotificationPoint p = NotificationPoint.create("Days", String.valueOf(Calendar.MONTH), "1");

        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(p.getCalenderType(), p.getValue());

                Calendar c = Calendar.getInstance();
                c.roll(Calendar.MONTH, -1);

                assertEquals(c.getTime().getMonth(), calendar.getTime().getMonth());
            }
        }
    }
}