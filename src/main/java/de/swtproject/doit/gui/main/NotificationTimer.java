package de.swtproject.doit.gui.main;

import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.util.Settings;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static de.swtproject.doit.gui.main.MainController.mainView;

/**
 * Created by Martin on 07.06.2018.
 */
public class NotificationTimer {

    /**
     * Start the notification timer.
     */
    public static void start() {
        new Timer().scheduleAtFixedRate(new LoopTask(), new Date(), Settings.getNotificationInterval());
    }

    /**
     * Looks for todos not notified.
     *
     * @throws SQLException when a sql exception occurs
     */
    private static void checkToDos() throws SQLException {
        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(Calendar.DAY_OF_YEAR, -1);

                if(calendar.before(Calendar.getInstance())){
                    renderNotification(todo);
                }
            }
        }
    }

    /**
     * Render the dialog message.
     *
     * @param toNotify the todo to display
     * @throws SQLException when a sql exception occurs
     */
    private static void renderNotification(ToDo toNotify) throws SQLException {
        toNotify.setNotified(true);
        toNotify.update();

        JOptionPane.showMessageDialog(mainView, toNotify.getDescription(), toNotify.getTitle(), JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Class to call every n seconds.
     *
     * @author Ruben Maurer
     * @version 1.0
     */
    private static class LoopTask extends TimerTask {

        /**
         * Runs every n seconds.
         */
        public void run() {
            try {
                checkToDos();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
