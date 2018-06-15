package de.swtproject.doit.core;

import de.swtproject.doit.gui.notification.NotificationController;
import de.swtproject.doit.util.Settings;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Martin on 07.06.2018.
 */
public class NotificationTimer {

    public static void start(){
        new Timer().scheduleAtFixedRate(new LoopTask(), new Date(), Settings.getNotificationInterval());
    }

    private static void checkToDos() throws SQLException{
        for (ToDo todo : DatabaseManager.getNotNotifiedTasks()) {
            if(todo.getStart() != null){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(todo.getStart());
                calendar.add(Calendar.DAY_OF_YEAR, -1);

                if(calendar.before(Calendar.getInstance())){
                    NotificationController.notifier.add(todo);
                }
            }
        }

        if(!NotificationController.notifier.isEmpty()){
            NotificationController.showDialog();
        }
    }

    private static class LoopTask extends TimerTask {
        public void run(){
            try {
                checkToDos();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
