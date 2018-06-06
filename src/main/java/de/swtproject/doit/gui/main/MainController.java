package de.swtproject.doit.gui.main;

import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.gui.create.CreateController;
import de.swtproject.doit.gui.util.PriorityCellRenderer;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;


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
        this.fillToDoList(true);
    }

    /**
     * Load the production {@link ToDo}s from database
     * and display them in a JList.
     */
    private void fillToDoList(boolean isProd) {
        try {
            ToDo to = null;
            DefaultListModel<ToDo> model = new DefaultListModel<>();
            for (ToDo todo : DatabaseManager.getCollection(isProd)) {
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
        fillToDoList(true);
    }

    /**
     * Exports all {@Link ToDo}s to a
     * selectable file on the disk.
     * @throws IOException on an exception with the IO.
     */
    public void exportToDos() throws IOException {
        JFileChooser c = new JFileChooser();
        ListModel<ToDo> model = mainView.todoTable.getModel();
        JSONObject dataset = new JSONObject();
        dataset.put("todos", new JSONArray());

        int rVal = c.showSaveDialog(mainView);

        if (rVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < model.getSize(); i++) {
                dataset.append("todos", model.getElementAt(i).serialize());
            }
            System.out.println(c.getCurrentDirectory().toString());
            System.out.println(c.getSelectedFile().getPath());
            Path file = Paths.get(c.getSelectedFile().getPath());
            Files.write(file, Arrays.asList(dataset.toString()), Charset.forName("UTF-8"));
        }
    }

    /**
     * The managed view.
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
        mainView.setArchivButtonListener(new ArchivListener());
        mainView.setProdButtonListener(new ProdListener());
        mainView.setExportJSONMenuListener(new ExportJSONListener());
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

    /**
     * Listener for clicking the prodButton.
     *
     * @author Jannik Schwardt
     * @version 1.0
     * @since 0.2
     */
    class ProdListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.isProd = true;
            fillToDoList(mainView.isProd);
        }
    }

    /**
     * Listener for clicking the openCreateButton.
     *
     * @author Jannik Schwardt
     * @version 1.0
     * @since 0.2
     */
    class ArchivListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.isProd = false;
            fillToDoList(mainView.isProd);
        }
    }

    /**
     * Listener for exporting the {@Link ToDo}s to a JSON file.
     * @author Niklas Kühtmann
     */
    class ExportJSONListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exportToDos();
            } catch(IOException ex) {

            }
        }
    }
}
