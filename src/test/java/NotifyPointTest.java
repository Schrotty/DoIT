import de.swtproject.doit.core.NotificationPoint;
import org.junit.Test;

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
}