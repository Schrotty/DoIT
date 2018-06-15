package de.swtproject.doit.gui.filter;

import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.core.FilterType;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.gui.main.MainController;

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
        this.filterView.setModal(true);
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
        filterView.setPriorityListener(new PriorityListener());
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

            boolean isProd = parent.mainView.isProd();

            try {
                // Filter for title
                if (filterView.getComboBoxChoice().equals(FilterType.TITLE.getName())) {
                    DatabaseManager.getCollection(isProd).forEach(t -> {
                        if (t.getTitle().toLowerCase().contains(inputValue.toLowerCase())) {
                            toDos.add(t);
                        }
                    });
                }

                // Filter for start date
                if (filterView.getComboBoxChoice().equals(FilterType.START.getName())
                        && null != filterView.dateButton.getDate()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    DatabaseManager.getCollection(isProd).forEach(t -> {
                        if (null != t.getStart()) {
                            if (sdf.format(t.getStart()).equals(sdf.format(filterView.dateButton.getDate()))) {
                                toDos.add(t);
                            }
                        }
                    });
                }

                // Filter for deadline
                if (filterView.getComboBoxChoice().equals(FilterType.DEADLINE.getName())
                        && null != filterView.dateButton.getDate()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    DatabaseManager.getCollection(isProd).forEach(t -> {
                        if (null != t.getDeadline()) {
                            if (sdf.format(t.getDeadline()).equals(sdf.format(filterView.dateButton.getDate()))) {
                                toDos.add(t);
                            }
                        }
                    });
                }

                // Filter for priority
                if (filterView.getComboBoxChoice().equals(FilterType.PRIORITY.getName())) {
                    DatabaseManager.getCollection(isProd).forEach(t -> {
                        if (t.getPriority().getName().equals(filterView.getPriorityChoice())) {
                            toDos.add(t);
                        }
                    });
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            if (toDos.isEmpty()) {
                clearFilter();
            } else {
                parent.alterToDoList(toDos);
            }
            filterView.dispose();
        }

        private void clearFilter() {
            try {
                parent.alterToDoList(DatabaseManager.getCollection(parent.mainView.isProd()));
            } catch (Exception ex) {
                ex.printStackTrace();
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
    class ComboBoxListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @SuppressWarnings("ConstantConditions")
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = (String) filterView.chooseComboBox.getSelectedItem();
            filterView.setComboBoxChoice(choice);

            if (choice.equals(FilterType.DEADLINE.getName()) || choice.equals(FilterType.START.getName())) {
                changeVisibility(false, true, false);
            } else if (choice.equals(FilterType.PRIORITY.getName())) {
                changeVisibility(false, false, true);
            } else {
                changeVisibility(true, false, false);
            }
        }

        /**
         * Sets the visibility for given components
         * @param textVisible text input visibility
         * @param dateVisible date input visibility
         * @param prioVisible priority input visibility
         */
        private void changeVisibility(boolean textVisible, boolean dateVisible, boolean prioVisible) {
            filterView.valueTextField.setVisible(textVisible);
            filterView.valuePanel.setVisible(textVisible);
            filterView.dateButton.setVisible(dateVisible);
            filterView.priorityComboBox.setVisible(prioVisible);
        }
    }

    /**
     * Listener for clicking the PriorityComboBox
     *
     * @author Jannik Schwardt
     * @version 1.0
     * @since 0.2
     */
    class PriorityListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @SuppressWarnings("ConstantConditions")
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = (String) filterView.priorityComboBox.getSelectedItem();
            filterView.setPriorityChoice(choice);
        }
    }
}
