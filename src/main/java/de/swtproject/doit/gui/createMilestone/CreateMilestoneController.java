package de.swtproject.doit.gui.createMilestone;

import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.Milestone;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.gui.create.CreateToDo;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

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
     * optional milestone to edit
     */
    private Milestone currentMilestoneToEdit;

    /**
     * The managed {@link CreateToDo}.
     */
    private CreateMilestone createView;

    /**
     * The parent {@link MainController}.
     */
    private MainController parent;

    private List<ToDo> toDoList = new LinkedList<>();

    /**
     * Constructor for {@link CreateMilestoneController}.
     *
     * @param parent the parent {@link MainController}
     */
    private CreateMilestoneController(MainController parent, Milestone optMilestoneToEdit) {

        currentMilestoneToEdit = optMilestoneToEdit;

        try {
            toDoList.addAll(DatabaseManager.getCollection(false));
            toDoList.addAll(DatabaseManager.getCollection(true));
            this.createView = new CreateMilestone(this.toDoList, optMilestoneToEdit);


        } catch (SQLException e) {
            e.printStackTrace();
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
    public static void showView(MainController parent, Milestone optMilestone) {
        new CreateMilestoneController(parent, optMilestone).createView.setVisible(true);
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


                Milestone m = currentMilestoneToEdit == null ? Milestone.create(createView.titleTextField.getText()) : currentMilestoneToEdit;

                m.setTitle(createView.titleTextField.getText());

                m.setDescription(createView.descriptionTextArea.getText());

                m.setStart(createView.dateToStartButton.getDate());
                m.setDeadline(createView.deadlineButton.getDate());

                int[] selectedTodos = createView.todoList.getSelectedIndices();

                try {

                    if(currentMilestoneToEdit != null)
                        currentMilestoneToEdit.getAssignedToDos().clear();

                    List<ToDo> milestoneToDos = new LinkedList<>();

                    for(int i : selectedTodos)
                    {
                        milestoneToDos.add(toDoList.get(i));
                    }

                    m.setAssignedToDos(milestoneToDos);

                    if(currentMilestoneToEdit != null)
                        currentMilestoneToEdit.update();
                    else
                        DatabaseManager.storeMilestone(m);


                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                parent.updateMilestoneList();
                parent.displayToDo(parent.getCurrentToDo());

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



            return isValid;
        }
    }
}
