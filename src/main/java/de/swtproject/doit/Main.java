package de.swtproject.doit;

import de.swtproject.doit.gui.main.NotificationTimer;
import de.swtproject.doit.gui.main.MainController;

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
        MainController.showView();
        NotificationTimer.start();
    }
}
