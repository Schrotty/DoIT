package de.swtproject.doit.gui.create;

import de.swtproject.doit.core.*;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    private List<Milestone> milestones;

    /**
     * The parent {@link MainController}.
     */
    private MainController parent;

    /**
     * Constructor for {@link CreateController}.
     *
     * @param parent the parent {@link MainController}
     */
    private CreateController(MainController parent)
    {
        try
        {
            milestones = DatabaseManager.getAllMilestones(true);
            this.createView = new CreateToDo(milestones);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            milestones = new LinkedList<>();
        }

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
                    todo.setPriority(Priority.valueOf(createView.prioritySelect.getSelectedItem().toString().toUpperCase()));
                    todo.setInterval(IntervalType.valueOf(createView.intervalComboBox.getSelectedItem().toString().toUpperCase()));
                    todo.setStart(createView.dateToStartButton.getDate());
                    todo.setDeadline(createView.deadlineButton.getDate());

                    DatabaseManager.storeToDo(todo);
                    parent.mainView.setProd(true);

                    int idx = createView.milestonesOptionsComboBox.getSelectedIndex();


                    if(idx != 0)
                    {
                        List<ToDo> oldTodosOfMilestone = milestones.get(idx - 1).getAssignedToDos();
                        oldTodosOfMilestone.add(todo);
                        milestones.get(idx - 1).setAssignedToDos(oldTodosOfMilestone);
                        milestones.get(idx - 1).update();
                    }

                    parent.updateList(parent.mainView.isProd());
                    parent.displayToDo(todo);
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