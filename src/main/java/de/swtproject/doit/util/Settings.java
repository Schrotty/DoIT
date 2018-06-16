package de.swtproject.doit.util;

import de.swtproject.doit.core.NotificationPoint;
import de.swtproject.doit.core.ToDo;

import java.io.*;
import java.util.Calendar;
import java.util.Properties;

/**
 * Settings controller for accessing the settings.
 * Settings are stored in the 'config.properties' in the resource directory.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.1
 */
public class Settings {

    /**
     * The Singleton
     */
    private static Settings self = new Settings();

    /**
     * The loaded system properties
     */
    private Properties sysProps = new Properties();

    /**
     * The loaded user properties
     */
    private Properties usrProps = new Properties();

    /**
     * Keyword for the notify display preference.
     */
    private static final String NOTIFY_DISPLAY = "USER_NOTIFICATION_DISPLAY";

    /**
     * Keyword for the notify display preference.
     */
    private static final String NOTIFY_TYPE = "USER_NOTIFICATION_TYPE";

    /**
     * Keyword for the notify value preference.
     */
    private static final String NOTIFY_VALUE = "USER_NOTIFICATION_VALUE";

    /**
     * Constructor for new settings singleton.
     */
    private Settings() {
        try (InputStream sysProps = ToDo.class.getClassLoader().getResourceAsStream("config.properties")) {
            this.sysProps.load(sysProps);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static boolean initUsrSettings() {
        File usrConfig = new File(Settings.getUserPropertiesPath());

        if (!usrConfig.exists()) {
            try {
                usrConfig.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
                return false;
            }
        }

        try (InputStream usrProps = new FileInputStream(usrConfig)) {
            self.usrProps.load(usrProps);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public static boolean isUsrSettingsInit() {
        return new File(Settings.getUserPropertiesPath()).exists();
    }

    /**
     * Get the jdbc connection string.
     *
     * @return the connection string
     */
    public static String getConnectionString() {
        return self.get("conString");
    }

    /**
     * Get the path for the data directory.
     *
     * @return the data dir path
     */
    public static String getDataDir() {
        return self.get("dataDir");
    }

    /**
     * Get the notification interval.
     *
     * @return the interval
     */
    public static int getNotificationInterval() {
        return Integer.parseInt(self.get("notificationInterval")) * 1000;
    }

    /**
     * Get the users properties file path.
     *
     * @return the file path
     */
    public static String getUserPropertiesPath() {
        return self.get("usrFile");
    }

    /**
     * Get the stored notification point.
     *
     * @return the notification point
     */
    public static NotificationPoint getNotificationPoint() {
        return NotificationPoint.create(
                self.usrProps.getProperty(NOTIFY_DISPLAY, "Days"),
                self.usrProps.getProperty(NOTIFY_TYPE, String.valueOf(Calendar.DAY_OF_YEAR)),
                self.usrProps.getProperty(NOTIFY_VALUE, "1")
        );
    }

    /**
     * Set the stored notification point.
     *
     * @param point the notification point to store
     */
    public static boolean setNotificationPoint(NotificationPoint point) {
        self.usrProps.setProperty(NOTIFY_DISPLAY, point.getDisplayName());
        self.usrProps.setProperty(NOTIFY_TYPE, String.valueOf(point.getCalenderType()));
        self.usrProps.setProperty(NOTIFY_VALUE, String.valueOf(point.getRawValue()));

        try {
            self.usrProps.store(new FileOutputStream(Settings.getUserPropertiesPath()), null);
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Get the value of a given property.
     *
     * @param key the property
     * @return the loaded value
     */
    private String get(String key) {
        return sysProps.getProperty(key);
    }
}
