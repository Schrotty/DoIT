package de.swtproject.doit.gui;

import com.toedter.calendar.JDateChooser;
import de.swtproject.doit.core.IntervalType;
import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.core.DatabaseManager;
import de.swtproject.doit.gui.main.Mainsite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

/**
 * The type Edit.
 */
public class Edit extends javax.swing.JFrame {
    /**
     * The Mainsite.
     */
    protected Mainsite mainsite;
    /**
     * The Milestone combo box.
     */
    private JComboBox<String> MilestoneComboBox;
    /**
     * The Milestone panel.
     */
    private JPanel MilestonePanel;
    /**
     * The Cancel button.
     */
    private JButton cancelButton;
    /**
     * The Date to start button.
     */
    private JDateChooser dateToStartButton;
    /**
     * The Deadline button.
     */
    private JDateChooser deadlineButton;
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
    private JTextArea descriptionTextArea;
    /**
     * The Interval combo box.
     */
    private JComboBox<String> intervalComboBox;
    /**
     * The Interval panel.
     */
    private JPanel intervalPanel;
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
    private JTextField titleTextField;
    /**
     * Instantiates a new Edit.
     */
    public Edit() {
        initComponents();
    }

    /**
     * Init components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new JPanel();
        titleTextField = new JTextField();
        dateToStartButton = new JDateChooser();
        deadlineButton = new JDateChooser();
        descriptionPanel = new JPanel();
        descriptionScrollPane = new JScrollPane();
        descriptionTextArea = new JTextArea();
        MilestonePanel = new JPanel();
        MilestoneComboBox = new JComboBox<>();
        intervalPanel = new JPanel();
        intervalComboBox = new JComboBox<>();
        cancelButton = new JButton();
        submitButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit ToDo");

        titlePanel.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102), null, null),
                        "Title", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));

        titleTextField.setFont(new java.awt.Font("Tahoma", 1, mainsite.fontsize));
        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        dateToStartButton.setFont(new java.awt.Font("Tahoma", 1, mainsite.fontsize)); // NOI18N
        dateToStartButton.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102),
                                null, null), "Date to Start",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));


        deadlineButton.setFont(new java.awt.Font("Tahoma", 1, mainsite.fontsize)); // NOI18N
        deadlineButton.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
                                new java.awt.Color(102, 102, 102), null, null),
                        "Deadline", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));

        descriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null,
                                new java.awt.Color(102, 102, 102), null, null),
                        "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionScrollPane.setViewportView(descriptionTextArea);

        javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
                descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionScrollPane)
        );
        descriptionPanelLayout.setVerticalGroup(
                descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        MilestonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102), null, null),
                        "Milestone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));

        MilestoneComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MilestoneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nothing Selected"}));

        javax.swing.GroupLayout MilestonePanelLayout = new javax.swing.GroupLayout(MilestonePanel);
        MilestonePanel.setLayout(MilestonePanelLayout);
        MilestonePanelLayout.setHorizontalGroup(
                MilestonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MilestoneComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MilestonePanelLayout.setVerticalGroup(
                MilestonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MilestoneComboBox)
        );

        intervalPanel.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102), null, null),
                        "Interval", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("Tahoma", 1, mainsite.fontsize)));
        intervalComboBox.setFont(new java.awt.Font("Tahoma", 0, 18));
        intervalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Nothing Selected"}));
        intervalComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout intervalPanelLayout = new javax.swing.GroupLayout(intervalPanel);
        intervalPanel.setLayout(intervalPanelLayout);
        intervalPanelLayout.setHorizontalGroup(
                intervalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(intervalComboBox, 0, 301, Short.MAX_VALUE)
        );
        intervalPanelLayout.setVerticalGroup(
                intervalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(intervalComboBox)
        );

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, mainsite.fontsize));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                null, new java.awt.Color(102, 102, 102), null, null));

        submitButton.setFont(new java.awt.Font("Tahoma", 1, mainsite.fontsize));
        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                null, new java.awt.Color(102, 102, 102), null, null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(MilestonePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(descriptionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateToStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deadlineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(intervalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateToStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(descriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addComponent(deadlineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MilestonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(intervalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        for (IntervalType intervalType : IntervalType.values()) {
            String inter = String.format("%s%s", intervalType.toString().substring(0, 1), intervalType.toString().substring(1).toLowerCase());
            intervalComboBox.addItem(inter);
        }

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Title text field action performed.
     *
     * @param evt the evt
     */
    private void titleTextFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTextFieldActionPerformed

    /**
     * Interval combo box action performed.
     *
     * @param evt the evt
     */
    private void intervalComboBoxActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_intervalComboBoxActionPerformed


    /**
     * Set submit button action perdormed.
     *
     * @param evt the evt
     */
    private void setSubmitButtonActionPerdormed(ActionEvent evt) {
        try {
            ToDo editToDo = ToDo.create(titleTextField.getText());
            editToDo.setDescription(descriptionTextArea.getText());
            editToDo.setInterval(IntervalType.valueOf(intervalComboBox.getSelectedItem().toString().toUpperCase()));
            editToDo.setStart(dateToStartButton.getDate());
            editToDo.setDeadline(deadlineButton.getDate());
            DatabaseManager.storeToDo(editToDo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dispose();
    }

    /**
     * Cancel button action performed.
     *
     * @param evt the evt
     */
    private void cancelButtonActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables

}
