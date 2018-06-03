package de.swtproject.doit.gui.filter;

import com.toedter.calendar.DateUtil;
import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.FilterType;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the {@link Filter}.
 *
 * @author Jannik Schwardt
 * @version 1.0
 * @since 0.2
 */
public class FilterController {

    /**
     * The managed {@link Filter}.
     */
    private Filter filterView;

    /**
     * The parent {@link MainController}.
     */
    private MainController parent;

    /**
     * Constructor for {@link FilterController}.
     *
     * @param parent the parent {@link MainController}
     */
    private FilterController(MainController parent) {
        this.filterView = new Filter();
        this.parent = parent;
        this.registerListener();
    }

    /**
     * Show the managed view.
     *
     * @param parent the parent
     */
    public static void showView(MainController parent) {
        new FilterController(parent).filterView.setVisible(true);
    }

    /**
     * Register all needed listener.
     */
    private void registerListener() {
        filterView.setCancelButtonListener(new CancelButtonListener());
        filterView.setSubmitButtonListener(new SubmitButtonListener());
        filterView.setComboBoxListener(new ComboBoxListener());
        filterView.setValueButtonListener(new ValueButtonListener());
    }

    class CancelButtonListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            filterView.dispose();
        }
    }

    /**
     * Listener for clicking the submitButton.
     *
     * @author Jannik Schwardt
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
            String inputValue = filterView.getValueTextField().getText();
            List<ToDo> toDos = new ArrayList<>();

            try {
                if (filterView.getComboBoxChoice().equals(FilterType.TITLE.getName())) {
                    DatabaseManager.getCollection(true).forEach(t -> {
                        if (t.getTitle().toLowerCase().contains(inputValue.toLowerCase())) {
                            toDos.add(t);
                        }
                    });
                }

                if (filterView.getComboBoxChoice().equals(FilterType.START.getName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    DatabaseManager.getCollection(true).forEach(t -> {
                        if (null != t.getStart()) {
                            if (sdf.format(t.getStart()).equals(sdf.format(filterView.date.getDate()))) {
                                toDos.add(t);
                            }
                        }
                    });
                }

                if (filterView.getComboBoxChoice().equals(FilterType.DEADLINE.getName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    DatabaseManager.getCollection(true).forEach(t -> {
                        if (null != t.getDeadline()) {
                            if (sdf.format(t.getDeadline()).equals(sdf.format(filterView.date.getDate()))) {
                                toDos.add(t);
                            }
                        }
                    });
                }

//                if(filterView.getComboBoxChoice().equals(FilterType.PRIORITY.getName())) {
//                    DatabaseManager.getCollection(true).forEach(t -> {
//                        if (t.getPriority().equals(inputValue)) {
//                            toDos.add(t);
//                        }
//                    });
//                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                if (filterView.getComboBoxChoice().equals("") && null == filterView.date.getDate()) {
                    parent.alterToDoList(DatabaseManager.getCollection(true));
                } else {
                    parent.alterToDoList(toDos);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            filterView.dispose();
        }
    }

    /**
     * Listener for clicking the ComboBox
     *
     * @author Jannik Schwardt
     * @version 1.0
     * @since 0.2
     */
    class ComboBoxListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = (String) ((JComboBox) e.getSource()).getSelectedItem();
            filterView.setComboBoxChoice(choice);

            if (choice.equals(FilterType.DEADLINE.getName()) || choice.equals(FilterType.START.getName())) {
                filterView.valueTextField.setVisible(false);
                filterView.valuePanel.setVisible(false);
                filterView.date.setVisible(true);
            } else {
                filterView.valueTextField.setVisible(true);
                filterView.valuePanel.setVisible(true);
                filterView.date.setVisible(false);
            }
        }
    }

    /**
     * Listener for clicking the ComboBox
     *
     * @author Jannik Schwardt
     * @version 1.0
     * @since 0.2
     */
    class ValueButtonListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
