package de.swtproject.doit.gui.main;

import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.gui.create.CreateController;
import de.swtproject.doit.gui.util.PriorityCellRenderer;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Controller for the {@link Mainsite}.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.2
 */
public class MainController {

    /**
     * The managed {@link Mainsite}.
     */
    private Mainsite mainView;

    /**
     * Constructor for {@link MainController}.
     */
    private MainController() {
        this.mainView = new Mainsite();
        this.registerListener();
        this.fillToDoList();
    }

    /**
     * Load the production {@link ToDo}s from database
     * and display them in a JList.
     */
    private void fillToDoList() {
        try {
            ToDo to = null;
            DefaultListModel<ToDo> model = new DefaultListModel<>();
            for (ToDo todo : DatabaseManager.getCollection(true)) {
                if (to == null) to = todo;

                model.addElement(todo);
            }

            mainView.todoTable.setCellRenderer(new PriorityCellRenderer());
            mainView.todoTable.setModel(model);
            displayToDo(to);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display a given {@link ToDo}.
     *
     * @param todo the {@link ToDo} to display.
     */
    private void displayToDo(ToDo todo) {
        if (todo != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            mainView.title.setText(todo.getTitle());
            mainView.description.setText(todo.getDescription());
            mainView.priorityLabel.setText(todo.getPriority().name);

            mainView.dateLabel.setText(todo.getStart() != null ? formatter.format(todo.getStart()) : "-");
            mainView.notifypointLabel.setText(todo.getDeadline() != null ? formatter.format(todo.getDeadline()) : "-");
        }
    }

    /**
     * Remove all {@link ToDo}s from list
     * and re-fill list with todos, now
     * including the recently added one.
     */
    public void updateList(ToDo toDo) {
        mainView.todoTable.removeAll();
        fillToDoList();
    }

    /**
     * The the managed view.
     */
    public static void showView() {
        new MainController().mainView.setVisible(true);
    }

    /**
     * Register all needed listeners.
     */
    private void registerListener() {
        mainView.setCreateToDoMenuListener(new OpenCreateViewListener(this));
        mainView.setToDoTabelListener(new ChangeToDoListener());
    }

    /**
     * Listener for clicking the openCreateButton.
     *
     * @author Ruben Maurer
     * @version 1.0
     * @since 0.2
     */
    class OpenCreateViewListener implements ActionListener {
        private MainController parent;

        OpenCreateViewListener(MainController mainController) {
            this.parent = mainController;
        }

        public void actionPerformed(ActionEvent e) {
            CreateController.showView(parent);
        }
    }

    /**
     * Listener for changing the selected item in the todoList.
     *
     * @author Ruben Maurer
     * @version 1.0
     * @since 0.2
     */
    class ChangeToDoListener implements ListSelectionListener {

        /**
         * Called whenever the value of the selection changes.
         *
         * @param e the event that characterizes the change.
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            displayToDo((ToDo)mainView.todoTable.getSelectedValue());
        }
    }
}
