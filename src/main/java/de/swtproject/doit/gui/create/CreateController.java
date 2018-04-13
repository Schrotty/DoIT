package de.swtproject.doit.gui.create;

import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Controller for the {@link CreateToDo}.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.2
 */
public class CreateController {

    /**
     * The managed {@link CreateToDo}.
     */
    private CreateToDo createView;

    /**
     * The parent {@link MainController}.
     */
    private MainController parent;

    /**
     * Constructor for {@link CreateController}.
     *
     * @param parent the parent {@link MainController}
     */
    private CreateController(MainController parent) {
        this.createView = new CreateToDo();
        this.createView.setModal(true);

        this.parent = parent;
        this.registerListener();
    }

    /**
     * Show the managed view.
     *
     * @param parent the parent
     */
    public static void showView(MainController parent) {
        new CreateController(parent).createView.setVisible(true);
    }

    /**
     * Register all needed listener.
     */
    private void registerListener() {
        createView.setCancelButtonListener(new CancelButtonListener());
        createView.setSubmitButtonListener(new SubmitButtonListener());
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
            createView.dispose();
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
                    ToDo todo = ToDo.create(createView.titleTextField.getText());

                    todo.setDescription(createView.descriptionTextArea.getText());
                    todo.setInterval(IntervalType.valueOf(createView.intervalComboBox.getSelectedItem().toString().toUpperCase()));
                    todo.setStart(createView.dateToStartButton.getDate());
                    todo.setDeadline(createView.deadlineButton.getDate());

                    parent.updateList(DatabaseManager.storeToDo(todo));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                createView.dispose();
                return;
            }

            JOptionPane.showMessageDialog(createView, "Invalid input!");
        }

        /**
         * Validates the createToDoForm.
         *
         * @return is input valid?
         */
        private boolean validateForm() {
            boolean isValid = true;

            if (createView.dateToStartButton.getDate() != null) {
                boolean sameDay = createView.dateToStartButton.getCalendar().get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR) &&
                        createView.dateToStartButton.getCalendar().get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR);

                if (!sameDay) isValid = createView.dateToStartButton.getDate().after(new Date());
            }

            if (createView.dateToStartButton.getDate() != null && createView.deadlineButton.getDate() != null && isValid) {
                isValid = createView.dateToStartButton.getDate().before(createView.deadlineButton.getDate());
            }

            if (createView.titleTextField.getText().isEmpty() || createView.titleTextField.getText() == null) {
                isValid = false;
            }

            return isValid;
        }
    }
}
