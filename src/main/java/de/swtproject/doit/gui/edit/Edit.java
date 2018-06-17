package de.swtproject.doit.gui.edit;

import com.toedter.calendar.JDateChooser;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.Priority;
import de.swtproject.doit.gui.main.MainController;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * The type edit.
 */
public class Edit extends JDialog {
    /**
     * The Mainsite.
     */
    private static final int fontsize = 16;

    /**
     * The Milestone combo box.
     */
    // Variables declaration - do not modify
    private JButton cancelButton;
    /**
     * The Create to do label.
     */
    private JLabel editLabel;
    /**
     * The Date to start button.
     */
    JDateChooser dateToStartButton;
    /**
     * The Deadline button.
     */
    JDateChooser deadlineButton;
    /**
     * The Description panel.
     */
    private JPanel descriptionPanel;
    /**
     * The Description scroll pane.
     */
    private JScrollPane descriptionScrollPane;
    /**
     * The Description text area.
     */
    JTextArea descriptionTextArea;
    /**
     * The Interval combo box.
     */
    JComboBox<String> intervalComboBox;
    /**
     * The Interval panel.
     */
    private JPanel intervalPanel;
    /**
     * The Mainpanel.
     */
    private JPanel mainpanel;
    /**
     * The Milestone panel.
     */
    private JPanel milestonePanel;
    /**
     * The Milestones options combo box.
     */
    public JComboBox<String> milestonesOptionsComboBox;
    /**
     * The Submit button.
     */
    private JButton submitButton;
    /**
     * The Title panel.
     */
    private JPanel titlePanel;
    /**
     * The Title text field.
     */
    JTextField titleTextField;
    /**
     * The Todo edit label.
     */
    private JLabel forEditLabel;

    /**
     * The priority select box.
     */
    public JComboBox<String> prioritySelect;

    /**
     * The priority select box panel.
     */
    public JPanel priorityPanel;
    // End of variables declaration

    /**
     * Instantiates a new edit.
     */
    public Edit() {
        initComponents();
    }

    /**
     * Init components.
     */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {
            mainpanel = new JPanel();
            editLabel = new JLabel();
            cancelButton = new JButton();
            dateToStartButton = new JDateChooser();
            deadlineButton = new JDateChooser();
            submitButton = new JButton();
            titlePanel = new JPanel();
            titleTextField = new JTextField();
            descriptionPanel = new JPanel();
            descriptionScrollPane = new JScrollPane();
            descriptionTextArea = new JTextArea();
            milestonePanel = new JPanel();
            milestonesOptionsComboBox = new JComboBox<>();
            intervalPanel = new JPanel();
            intervalComboBox = new JComboBox<>();
            forEditLabel = new JLabel();
            prioritySelect = new JComboBox<>();
            priorityPanel = new JPanel();

            setTitle("Edit ToDo");

            cancelButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
            cancelButton.setText("Cancel");
            cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

            submitButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
            submitButton.setText("Submit");
            submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));

            titlePanel.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null), "Title*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));

            titleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            titleTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

            GroupLayout titlePanelLayout = new GroupLayout(titlePanel);
            titlePanel.setLayout(titlePanelLayout);
            titlePanelLayout.setHorizontalGroup(
                    titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleTextField)
            );
            titlePanelLayout.setVerticalGroup(
                    titlePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(titleTextField, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
            );

            descriptionPanel.setBorder(BorderFactory.createTitledBorder
                    (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color
                                    (102, 102, 102), null, null),
                            "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                            new java.awt.Font("Tahoma", 1, fontsize)));

            descriptionTextArea.setFont(new java.awt.Font("Tahoma", 0, fontsize));
            descriptionTextArea.setColumns(20);
            descriptionTextArea.setRows(5);
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setLineWrap(true);

            descriptionScrollPane.setViewportView(descriptionTextArea);

            GroupLayout descriptionPanelLayout = new GroupLayout(descriptionPanel);
            descriptionPanel.setLayout(descriptionPanelLayout);
            descriptionPanelLayout.setHorizontalGroup(
                    descriptionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionScrollPane)
            );
            descriptionPanelLayout.setVerticalGroup(
                    descriptionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
                                    228, Short.MAX_VALUE)
            );

            milestonePanel.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                            null, new java.awt.Color(102, 102, 102), null, null),
                    "Milestone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font
                            ("Tahoma", 1, fontsize)));

            milestonesOptionsComboBox.setFont(new java.awt.Font("Tahoma", 1, fontsize));
            milestonesOptionsComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"None"}));
            milestonesOptionsComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                    null, new java.awt.Color(102, 102, 102), null, null));

            GroupLayout milestonePanelLayout = new GroupLayout(milestonePanel);
            milestonePanel.setLayout(milestonePanelLayout);
            milestonePanelLayout.setHorizontalGroup(
                    milestonePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(milestonesOptionsComboBox, 0, 315, Short.MAX_VALUE)
            );
            milestonePanelLayout.setVerticalGroup(
                    milestonePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(milestonesOptionsComboBox, GroupLayout.Alignment.TRAILING)
            );

            intervalPanel.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder
                            (javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102),
                                    null, null), "Interval", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));

            intervalComboBox.setFont(new java.awt.Font("Tahoma", 1, fontsize));
            //intervalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nothing Selected" }));
            intervalComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                    null, new java.awt.Color(102, 102, 102), null, null));

            GroupLayout intervalPanelLayout = new GroupLayout(intervalPanel);
            intervalPanel.setLayout(intervalPanelLayout);
            intervalPanelLayout.setHorizontalGroup(
                    intervalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(intervalComboBox, 0, 298, Short.MAX_VALUE)
            );
            intervalPanelLayout.setVerticalGroup(
                    intervalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(intervalComboBox, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
            );

            priorityPanel.setBorder(BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder
                            (javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102),
                                    null, null), "Priority", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                    javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));

            prioritySelect.setFont(new java.awt.Font("Tahoma", 1, fontsize));
            prioritySelect.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                    null, new java.awt.Color(102, 102, 102), null, null));

            GroupLayout priorityPanelLayout = new GroupLayout(priorityPanel);
            priorityPanel.setLayout(priorityPanelLayout);
            priorityPanelLayout.setHorizontalGroup(
                    priorityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(prioritySelect, 0, 315, Short.MAX_VALUE)
            );
            priorityPanelLayout.setVerticalGroup(
                    priorityPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(prioritySelect, GroupLayout.Alignment.TRAILING)
            );

            dateToStartButton.setBorder(BorderFactory.createTitledBorder
                    (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                    null, new java.awt.Color(102, 102, 102),
                                    null, null), "Date to Start", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                            javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));


            deadlineButton.setBorder(BorderFactory.createTitledBorder
                    (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                    null, new java.awt.Color(102, 102, 102),
                                    null, null), "Deadline", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                            javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));



            GroupLayout mainpanelLayout = new GroupLayout(mainpanel);
            mainpanel.setLayout(mainpanelLayout);
            mainpanelLayout.setHorizontalGroup(
                    mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(forEditLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(mainpanelLayout.createSequentialGroup()
                                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(descriptionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(milestonePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(priorityPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(7, 7, 7)
                                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addComponent(intervalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(deadlineButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(dateToStartButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
                                                    .addContainerGap(24, Short.MAX_VALUE))))
            );
            mainpanelLayout.setVerticalGroup(
                    mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(mainpanelLayout.createSequentialGroup()
                                    .addComponent(forEditLabel)
                                    .addGap(38, 38, 38)
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dateToStartButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(descriptionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainpanelLayout.createSequentialGroup()
                                                    .addGap(8, 8, 8)
                                                    .addComponent(deadlineButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(4, 4, 4)
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(milestonePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(intervalPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(4, 4, 4)
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(priorityPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(mainpanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                            .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            );


            GroupLayout layout = new GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(mainpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(forEditLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addComponent(forEditLabel)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(mainpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            int index = 0;
            int i = 0;

            for (IntervalType intervalType : IntervalType.values()) {
                if(MainController.getCurrentToDo().getInterval().name() == intervalType.name()){
                    index = i;
                }
                intervalComboBox.addItem(
                        String.format("%s%s", intervalType.toString().substring(0, 1), intervalType.toString().substring(1).toLowerCase())
                );
                i++;
            }

            for (Priority priority : Priority.values()) {
                if(MainController.getCurrentToDo().getPriority().name() == priority.name()){
                    index = i;
                }
               prioritySelect.addItem(
                       String.format("%s%s", priority.toString().substring(0, 1), priority.toString().substring(1).toLowerCase())
               );
                i++;
            }

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    /**
     * Cancel button action performed.
     */
    public void setCancelButtonListener(ActionListener e) {
        cancelButton.addActionListener(e);
    }

    /**
     * Submit button action performed.
     */
    public void setSubmitButtonListener(ActionListener e) {
        submitButton.addActionListener(e);
    }
}
