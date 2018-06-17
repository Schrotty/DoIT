import de.swtproject.doit.core.NotificationPoint;
import de.swtproject.doit.util.Settings;
import org.junit.Test;

import java.io.File;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SettingsTest {

    @org.junit.Before
    public void beforeEach() {
        File f = new File(Settings.getUserPropertiesPath());
        if (f.exists()) f.delete();
    }

    @Test
    public void notificationInterval() {
        assertEquals(10000, Settings.getNotificationInterval()); //default value
    }

    @Test
    public void setGetNotificationPoint() {
        if (!Settings.isUsrSettingsInit()) Settings.initUsrSettings();
        Settings.setNotificationPoint(NotificationPoint.create("Weeks", String.valueOf(Calendar.DAY_OF_YEAR), "5"));

        assertEquals("Weeks", Settings.getNotificationPoint().getDisplayName());
        assertEquals(Calendar.DAY_OF_YEAR, Settings.getNotificationPoint().getCalenderType());
        assertEquals(-5, Settings.getNotificationPoint().getValue());
        assertEquals(5, Settings.getNotificationPoint().getRawValue());
    }

    @Test
    public void initUsrSettings1() {
        assertTrue(Settings.initUsrSettings());
    }
}
