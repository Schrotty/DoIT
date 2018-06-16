package de.swtproject.doit.gui.main;

import de.swtproject.doit.core.*;
import de.swtproject.doit.gui.create.CreateController;

import de.swtproject.doit.gui.createMilestone.CreateMilestoneController;

import de.swtproject.doit.gui.filter.FilterController;
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
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


/**
 * Controller for the {@link Mainsite}.
 *
 * @author Ruben Maurer
 * @version 1.0
 * @since 0.2
 */
public class MainController {

    private static ToDo current;
    private static Milestone currSelectedMilestone = null;

    /**
     * The managed {@link Mainsite}.
     */
    public static Mainsite mainView;

    /**
     * Constructor for {@link MainController}.
     */
    private MainController() {
        mainView = new Mainsite();
        this.registerListener();
        this.fillToDoList(true);
        this.updateMilestoneList();

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

            if (isProd) switchButtonHighlight(mainView.archivButton, mainView.prodButton);
            if (!isProd) switchButtonHighlight(mainView.prodButton, mainView.archivButton);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display a given {@link ToDo}.
     *
     * @param todo the {@link ToDo} to display.
     */
    public void displayToDo(ToDo todo) {
        if (todo != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

            mainView.title.setText(todo.getTitle());
            mainView.description.setText(todo.getDescription());
            mainView.priorityLabel.setText(todo.getPriority().getName());

            mainView.dateLabel.setText(todo.getStart() != null ? formatter.format(todo.getStart()) : "-");
            mainView.notifypointLabel.setText(todo.getDeadline() != null ? formatter.format(todo.getDeadline()) : "-");
        } else {
            mainView.title.setText("");
            mainView.description.setText("");
            mainView.priorityLabel.setText("");

            mainView.dateLabel.setText("-");
            mainView.notifypointLabel.setText("-");
        }
    }

    public void alterToDoList(List<ToDo> toDos) {
        ToDo to = null;
        DefaultListModel model = new DefaultListModel();
        for (ToDo toDo : toDos) {
            if (to == null)
                to = toDo;
            model.addElement(toDo);
        }
        mainView.todoTable.setModel(model);
        displayToDo(to);
    }

    /**
     * Remove all {@link ToDo}s from list
     * and re-fill list with todos, now
     * including the recently added one.
     */
    public void updateList(boolean isProd) {
        mainView.todoTable.removeAll();
        fillToDoList(isProd);
    }

    /**
     * Exports all {@Link ToDo}s to a
     * selectable file on the disk.
     *
     * @throws IOException on an exception with the IO.
     */
    public void exportToDos() throws IOException {
        ListModel<ToDo> model = mainView.todoTable.getModel();
        JFileChooser c = new JFileChooser();
        JSONObject dataset = new JSONObject();
        dataset.put("todos", new JSONArray());

        int rVal = c.showSaveDialog(mainView);

        if (rVal == JFileChooser.APPROVE_OPTION) {
            for (int i = 0; i < model.getSize(); i++) {
                dataset.append("todos", model.getElementAt(i).serialize());
            }
            Path file = Paths.get(c.getSelectedFile().getPath());
            Files.write(file, Arrays.asList(dataset.toString()), Charset.forName("UTF-8"));
        }
    }

    public void updateMilestoneList() {
        try {
            mainView.setMilestoneList(DatabaseManager.getAllMilestones(true));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void importToDos() throws IOException, SQLException {
        ListModel<ToDo> model = mainView.todoTable.getModel();
        JFileChooser c = new JFileChooser();

        int rVal = c.showOpenDialog(mainView);

        if (rVal == JFileChooser.APPROVE_OPTION) {
            Path file = Paths.get(c.getSelectedFile().getPath());
            String json = String.join(" ", Files.readAllLines(file, Charset.forName("UTF-8")));
            JSONObject dataset = new JSONObject(json);
            JSONArray todos = (JSONArray) dataset.get("todos");

            for (int i = 0; i < todos.length(); i++) {
                JSONObject data = (JSONObject) todos.get(i);

                if (data.has("title")) {
                    ToDo todo = ToDo.create((String) data.get("title"));

                    if (data.has("description")) todo.setDescription((String) data.get("description"));
                    if (data.has("priority")) todo.setPriority(Priority.valueOf((String) data.get("priority")));
                    if (data.has("interval")) todo.setInterval(IntervalType.valueOf((String) data.get("interval")));
                    if (data.has("start")) todo.setStart(Date.valueOf((String) data.get("start")));
                    if (data.has("deadline")) todo.setDeadline(Date.valueOf((String) data.get("deadline")));
                    if (data.has("notifyPoint")) todo.setNotifyPoint(Date.valueOf((String) data.get("notifyPoint")));

                    DatabaseManager.storeToDo(todo);
                    updateList(mainView.isProd());
                }
            }
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
        mainView.setCreateMilestoneListener(new OpenCreateMilestoneViewListener(this));
        mainView.setDeleteButtonListener(new DeleteListener());
        mainView.setArchivButtonListener(new ArchivListener());
        mainView.setProdButtonListener(new ProdListener());
        mainView.setFinishButtonListener(new FinishListener());
        mainView.setExportJSONMenuListener(new ExportJSONListener());
        mainView.setImportJSONMenuListener(new ImportJSONListener());
        mainView.setFilterButtonListener(new FilterListener(this));
    }

    private void switchButtonHighlight(JButton activate, JButton deactivate) {
        activate.setEnabled(true);
        deactivate.setEnabled(false);
    }

    private void switchCurrentButtonsState() {
        mainView.finishButton.setEnabled(current != null);
        mainView.editToDoButton.setEnabled(current != null);
        mainView.deleteToDoButton.setEnabled(current != null);
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
     * Listener for clicking the openCreateMilestoneButton.
     *
     * @author Ruben Maurer
     * @version 1.0
     * @since 0.2
     */
    class OpenCreateMilestoneViewListener implements ActionListener {
        private MainController parent;


        OpenCreateMilestoneViewListener(MainController mainController) {
            this.parent = mainController;
        }

        public void actionPerformed(ActionEvent e) {
            CreateMilestoneController.showView(parent, MainController.currSelectedMilestone);
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
            current = (ToDo)mainView.todoTable.getSelectedValue();
            displayToDo(current);

            switchCurrentButtonsState();
        }
    }

    class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (current != null)
                    current.delete();
            } catch (SQLException sql) {
                sql.printStackTrace();
            }

            updateList(mainView.isProd());
            switchCurrentButtonsState();
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
            mainView.setProd(true);
            fillToDoList(mainView.isProd());
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
            mainView.setProd(false);
            fillToDoList(mainView.isProd());
        }
    }

    /**
     * Listener for exporting the {@Link ToDo}s to a JSON file.
     *
     * @author Niklas Kühtmann
     */
    class ExportJSONListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                exportToDos();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(mainView, "Unable to export!");
            }
        }
    }

    /**
     * Listener for import {@Link ToDo}s from a JSON file.
     *
     * @author Niklas Kühtmann
     */
    class ImportJSONListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                importToDos();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(mainView, "Unable to import!");
            }
        }
    }

    /**
     * Listener for finish a todo.
     *
     * @author Ruben Maurer
     * @version 1.0
     */
    class FinishListener implements ActionListener {

        /**
         * Called when user clicks the finish todo button.
         *
         * @param e the event that characterizes the action.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                current.finish();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            switchCurrentButtonsState();
            fillToDoList(mainView.isProd);
        }
    }

    class FilterListener implements ActionListener {
        private MainController parent;

        FilterListener(MainController mainController) {
            this.parent = mainController;
        }

        public void actionPerformed(ActionEvent e) {
            FilterController.showView(parent);
        }
    }

}
