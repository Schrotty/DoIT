package de.swtproject.doit.gui.edit;

import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.Milestone;
import de.swtproject.doit.core.Priority;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * Controller for the {@link Edit}.
 *
 * @author Timo Steffen
 * @version 1.0
 * @since 0.2
 */
public class EditController {

        /**
         * The managed {@link Edit}.
         */
        private Edit editView;

         /**
           * The parent {@link MainController}.
           */
        private MainController parent;

        /**
         * Constructor for {@link de.swtproject.doit.gui.edit.EditController}.
         *
         * @param parent the parent {@link MainController}
         */
      private EditController(MainController parent) {
            this.editView = new Edit();
            this.editView.setModal(true);

            this.parent = parent;
            this.registerListener();
       }
        /**
         * Show the managed view.
         *
         * @param parent the kind
         */

        public static void showView(MainController parent) {
         try {
             EditController controller = new EditController(parent);
             for (Milestone mile : DatabaseManager.getAllMilestones(false)) {
                 controller.editView.milestonesOptionsComboBox.addItem(mile.toString());
             }
             controller.editView.titleTextField.setText(MainController.getCurrentToDo().getTitle());
             controller.editView.descriptionTextArea.setText(MainController.getCurrentToDo().getDescription());
             controller.editView.dateToStartButton.setDate(MainController.getCurrentToDo().getStart());
             controller.editView.deadlineButton.setDate(MainController.getCurrentToDo().getDeadline());
             fillSelects(controller);
             fillSelectsIntv(controller);

             for (Milestone mile : DatabaseManager.getAllMilestones(false)) {
                 for (int i = 0; i < controller.editView.milestonesOptionsComboBox.getModel().getSize(); i++) {
                     if (Objects.equals(mile.toString(), controller.editView.milestonesOptionsComboBox.getItemAt(i))) {
                         controller.editView.milestonesOptionsComboBox.setSelectedIndex(i);
                     }
                 }
             }
             controller.editView.setVisible(true);

         } catch (Exception ex) {
             ex.printStackTrace();
         }
        }

    /**
     * Show Priority Selection
     */
    private static void fillSelects(EditController controller) {
        Priority[] prios = new Priority[] { Priority.DEFAULT, Priority.UNIMPORTANT, Priority.IMPORTANT, Priority.URGENT};
        int index = 0;
        for (Priority prio : prios) {
            if (MainController.getCurrentToDo().getPriority() != null) {
                if (MainController.getCurrentToDo().getPriority().getName().equals(prio.getName())) {
                    controller.editView.prioritySelect.setSelectedIndex(index);
                }
            }
            index++;
        }
    }

    /**
     * Show Interval Selection
     */
    private static void fillSelectsIntv(EditController controller) {
        Priority[] prios = new Priority[] { Priority.DEFAULT, Priority.UNIMPORTANT, Priority.IMPORTANT, Priority.URGENT};
        int index = 0;
        for (Priority prio : prios) {
            if (MainController.getCurrentToDo().getPriority() != null) {
                if (MainController.getCurrentToDo().getPriority().getName().equals(prio.getName())) {
                    controller.editView.intervalComboBox.setSelectedIndex(index);
                }
            }
            index++;
        }
    }


        /**
         * Register all needed listener.
         */
        private void registerListener() {
            editView.setCancelButtonListener(new de.swtproject.doit.gui.edit.EditController.CancelButtonListener());
            editView.setSubmitButtonListener(new de.swtproject.doit.gui.edit.EditController.SubmitButtonListener());
        }

        /**
         * Listener for clicking the cancelButton.
         *
         * @author Ruben Maurer
         * @version 1.0
         * @since 0.2
         */
        class CancelButtonListener implements ActionListener {

            /**
             * Invoked when an action occurs.
             *
             * @param e the event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                editView.dispose();
            }
        }

        /**
         * Listener for clicking the submitButton.
         *
         * @author Ruben Maurer
         * @version 1.0
         * @since 0.2
         */
        class SubmitButtonListener implements ActionListener {

            /**
             * Invoked when an action occurs.
             *
             * @param e the event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    try {
                        MainController.getCurrentToDo().setTitle(editView.titleTextField.getText());
                        MainController.getCurrentToDo().setDescription(editView.descriptionTextArea.getText());
                        MainController.getCurrentToDo().setPriority(Priority.valueOf(editView.prioritySelect.getSelectedItem().toString().toUpperCase()));
                        MainController.getCurrentToDo().setInterval(IntervalType.valueOf(editView.intervalComboBox.getSelectedItem().toString().toUpperCase()));
                        MainController.getCurrentToDo().setStart(editView.dateToStartButton.getDate());
                        MainController.getCurrentToDo().setDeadline(editView.deadlineButton.getDate());
                        MainController.getCurrentToDo().update();


                        parent.updateList(parent.mainView.isProd());
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    editView.dispose();
                    return;
                }

                JOptionPane.showMessageDialog(editView, "Invalid input!");
            }

            /**
             * Validates the editForm.
             *
             * @return is input valid?
             */
            private boolean validateForm() {
                boolean isValid = true;

                if (editView.dateToStartButton.getDate() != null) {
                    boolean sameDay = editView.dateToStartButton.getCalendar().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR) &&
                            editView.dateToStartButton.getCalendar().get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

                    if (!sameDay) isValid = editView.dateToStartButton.getDate().after(new Date());
                }

                if (editView.dateToStartButton.getDate() != null && editView.deadlineButton.getDate() != null && isValid) {
                    isValid = editView.dateToStartButton.getDate().before(editView.deadlineButton.getDate());
                }

                if (editView.titleTextField.getText().isEmpty() || editView.titleTextField.getText() == null) {
                    isValid = false;
                }

                return isValid;
            }
        }
}