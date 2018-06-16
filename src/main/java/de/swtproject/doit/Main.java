package de.swtproject.doit;

import de.swtproject.doit.gui.main.MainController;
import de.swtproject.doit.gui.notification.NotificationTimer;
import de.swtproject.doit.util.Settings;

import javax.swing.*;

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
        if (!Settings.initUsrSettings()) JOptionPane.showMessageDialog(null, "Failure!", "Unable to initiliaze the user settings storage!", JOptionPane.ERROR_MESSAGE);

        MainController.showView();
        NotificationTimer.start();
    }
}
