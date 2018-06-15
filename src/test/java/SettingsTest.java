import de.swtproject.doit.util.Settings;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SettingsTest {

    @Test
    public void notificationInterval() {
        assertEquals(10000, Settings.getNotificationInterval()); //default value
    }
}
