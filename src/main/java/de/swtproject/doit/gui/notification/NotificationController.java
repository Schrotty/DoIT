package de.swtproject.doit.gui.notification;

import de.swtproject.doit.core.ToDo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NotificationController {
    private NotificationDialog dialog;
    public static List<ToDo> notifier = new LinkedList<>();
    private NotificationController(){
            this.dialog = new NotificationDialog();
            this.dialog.setModal(true);
            this.registerListener();
    }

    private void registerListener(){
        dialog.setSubmittonButtonListener(new SubmitButtonListener());
    }

    private void addRow(ToDo toDo){
        String start  = toDo.getStart() == null ? "" : toDo.getStart().toString();
        String end  = toDo.getDeadline() == null ? "" : toDo.getDeadline().toString();

        ((DefaultTableModel) dialog.toDoTable.getModel()).addRow(new Object []{toDo.getTitle(), start, end});
    }
    public static void showDialog(){

        NotificationController c = new NotificationController();

        notifier.forEach(toDo -> {
            c.addRow(toDo);

            toDo.setNotified(true);
            try {
                toDo.update();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        NotificationController.notifier.clear();
        c.dialog.setVisible(true);
    }



    class SubmitButtonListener implements ActionListener{

        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    }
}
