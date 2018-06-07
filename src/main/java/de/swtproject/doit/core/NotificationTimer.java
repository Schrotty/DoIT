package de.swtproject.doit.core;

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
                DatabaseManager.getCollection(true)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(todo.getStart());
            calendar.roll(Calendar.DAY_OF_MONTH, 1);

            if(calendar.after(new Date())){
                System.out.println("Nachricht");
            }

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
