package de.swtproject.doit.util;

import de.swtproject.doit.core.ToDo;

import java.io.IOException;
import java.io.InputStream;
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
     * The loaded properties
     */
    private Properties properties = new Properties();

    /**
     * Constructor for new settings singleton.
     */
    private Settings() {
        try (InputStream input = ToDo.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
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
     * Get the value of a given property.
     *
     * @param key the property
     * @return the loaded value
     */
    private String get(String key) {
        return properties.getProperty(key);
    }
}
