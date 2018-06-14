package de.swtproject.doit.gui.notification;

import de.swtproject.doit.core.ToDo;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class NotificationController {
    private ToDo display;
    private NotificationDialog dialog;
    public static List<ToDo> notifier = new LinkedList<>();


    private NotificationController(ToDo display){
            this.dialog = new NotificationDialog();
            this.dialog.setModal(true);
            this.dialog.title.setText(String.format("%s - has to be done", display.getTitle()));
            this.display = display;
            this.registerListener();
    }

    private void registerListener(){
        dialog.setSubmittonButtonListener(new SubmitButtonListener());
    }


    public static void showDialog(){



        notifier.forEach(toDo -> {
            NotificationController c = new NotificationController(toDo);
            c.dialog.setVisible(true);
            toDo.setNotified(true);
            try {
                toDo.update();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        NotificationController.notifier.clear();

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
