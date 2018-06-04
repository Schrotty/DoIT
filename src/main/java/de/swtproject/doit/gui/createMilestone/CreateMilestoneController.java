package de.swtproject.doit.gui.createMilestone;

import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.gui.create.CreateToDo;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Controller for the {@link CreateToDo}.
 *
 * @author Hans Wurst
 * @version 1.0
 * @since 0.2
 */
public class CreateMilestoneController
{

    /**
     * The managed {@link CreateToDo}.
     */
    private CreateMilestone createView;

    /**
     * The parent {@link MainController}.
     */
    private MainController parent;

    /**
     * Constructor for {@link CreateMilestoneController}.
     *
     * @param parent the parent {@link MainController}
     */
    private CreateMilestoneController(MainController parent) {
        this.createView = new CreateMilestone();
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
        new CreateMilestoneController(parent).createView.setVisible(true);
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


            if (createView.titleTextField.getText() == null ||createView.titleTextField.getText().isEmpty())
            {
                isValid = false;
            }

            int[] selectedTodos = createView.todoList.getSelectedIndices();


            for(int idx : selectedTodos)
            {
                System.out.println("cons: " + createView.todoList.getModel().getElementAt(idx));
            }


            return isValid;
        }
    }
}
