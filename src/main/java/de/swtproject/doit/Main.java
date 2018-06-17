package de.swtproject.doit;

import de.swtproject.doit.gui.main.MainController;
import de.swtproject.doit.gui.notification.NotificationTimer;
import de.swtproject.doit.util.Settings;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Settings.initUsrSettings();

        MainController.showView();
        NotificationTimer.start();
    }
}
