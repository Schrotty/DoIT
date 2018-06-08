package de.swtproject.doit.core;

import de.swtproject.doit.gui.notification.NotificationController;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Martin on 07.06.2018.
 */
public class NotificationTimer {
    long delay = 10 * 1000;
    LoopTask task = new LoopTask();
    Timer timer = new Timer();

    public void start(){
        timer.cancel();
        timer = new Timer();
        Date execdate = new Date();
        timer.scheduleAtFixedRate(task, execdate, delay);
    }

    public static void checkToDos() throws SQLException{
        for (ToDo todo :
                DatabaseManager.getNotNotifiedTasks()) {
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

    private class LoopTask extends TimerTask {
        public void run(){
            try {
                checkToDos();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        new NotificationTimer().start();
    }
}
