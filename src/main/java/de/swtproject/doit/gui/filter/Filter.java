package de.swtproject.doit.gui.filter;


import com.toedter.calendar.JDateChooser;
import de.swtproject.doit.core.FilterType;
import de.swtproject.doit.core.Priority;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import static de.swtproject.doit.gui.main.Mainsite.fontsize;


/**
 * The type Filter.
 */
public class Filter extends javax.swing.JDialog {

// Variables declaration - do not modify
    /**
     * The Apply button.
     */
    private javax.swing.JButton applyButton;
    /**
     * The Cancel button.
     */
    private javax.swing.JButton cancelButton;
    /**
     * The Choose combo box.
     */
    protected javax.swing.JComboBox<String> chooseComboBox;
    /**
     * The Filter panel.
     */
    private javax.swing.JPanel filterPanel;
    /**
     * The Mainpanel.
     */
    private javax.swing.JPanel mainpanel;
    /**
     * The Date Chooser
     */
    protected JDateChooser dateButton;
    /**
     * The Priority Chooser
     */
    protected javax.swing.JComboBox<String> priorityComboBox;
    /**
     * The Value panel.
     */
    protected javax.swing.JPanel valuePanel;
    /**
     * The Value text field.
     */
    protected javax.swing.JTextField valueTextField;
    /**
     * The chosen Filter.
     */
    private String filterChoice;
    /**
     * The chosen Priority
     */
    private String priorityChoice;
    // End of variables declaration

    /**
     * Creates new form Filter
     */
    public Filter() {
        initComponents();
        initFilterValues();
        initPriorityValues();
    }

    Font font = new java.awt.Font("Tahoma", Font.PLAIN, fontsize);

    /**
     * Init components.
     */
    @SuppressWarnings("all")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        filterPanel = new javax.swing.JPanel();
        chooseComboBox = new javax.swing.JComboBox<>();
        valuePanel = new javax.swing.JPanel();
        valueTextField = new javax.swing.JTextField();
        dateButton = new JDateChooser();
        priorityComboBox = new javax.swing.JComboBox<>();
        cancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Choose Filter");
        setResizable(false);

        mainpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Filter"));
        mainpanel.setPreferredSize(new Dimension(350, 300));
        mainpanel.setFont(font);

        SoftBevelBorder sbbFilter = new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null);
        filterPanel.setBorder(BorderFactory.createTitledBorder(sbbFilter, "Filter", 0, 0, font));

        chooseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"No Filter"}));
        chooseComboBox.setBorder(null);

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
                filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chooseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        filterPanelLayout.setVerticalGroup(
                filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chooseComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        SoftBevelBorder sbbValue = new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null);
        valuePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(sbbValue, "Value", 0, 0,font));

        valueTextField.setFont(font);
        valueTextField.setBorder(null);

        javax.swing.GroupLayout valuePanelLayout = new javax.swing.GroupLayout(valuePanel);
        valuePanel.setLayout(valuePanelLayout);
        valuePanelLayout.setHorizontalGroup(
                valuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(valueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)

        );
        valuePanelLayout.setVerticalGroup(
                valuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(valueTextField)
        );

        dateButton.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102),
                                null, null), "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, font));
        dateButton.setVisible(false);

        priorityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Choose a priority"}));
        priorityComboBox.setBorder(null);
        priorityComboBox.setVisible(false);

        valueTextField.setVisible(false);
        valuePanel.setVisible(false);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                        .addComponent(valuePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(priorityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        ))
                                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
//                                .addGap(55, 55, 55)
                                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(valuePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(priorityComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                .addGap(0, 30, Short.MAX_VALUE))
        );

        cancelButton.setFont(font);
        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        applyButton.setFont(font);
        applyButton.setText("Apply");
        applyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(applyButton)))
        );
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                windowEvent.getWindow().dispose();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    /**
     * Cancel button
     *
     * @param e the evt
     */
    public void setCancelButtonListener(ActionListener e) {
        cancelButton.addActionListener(e);
    }

    /**
     * Submit button
     *
     * @param e the evt
     */
    public void setSubmitButtonListener(ActionListener e) {
        applyButton.addActionListener(e);
    }

    /**
     * Choose Filter Combo
     *
     * @param e the event
     */
    public void setComboBoxListener(ActionListener e) {
        chooseComboBox.addActionListener(e);
    }

    /**
     * Choose Priority Combo
     *
     * @param e the event
     */
    public void setPriorityListener(ActionListener e) {
        priorityComboBox.addActionListener(e);
    }

    /**
     * Init FilterComboBox
     */
    private void initFilterValues() {
        EnumSet.allOf(FilterType.class).forEach(type -> this.chooseComboBox.addItem(type.getName()));
    }

    /**
     * Init PriorityComboBox
     */
    private void initPriorityValues() {
        EnumSet.allOf(Priority.class).forEach(type -> this.priorityComboBox.addItem(type.getName()));
    }

    /**
     * Getters & Setters
     */
    public JTextField getValueTextField() {
        return valueTextField;
    }

    public String getComboBoxChoice() {
        if (null == filterChoice) return "";
        return filterChoice;
    }

    public void setComboBoxChoice(String choice) {
        this.filterChoice = choice;
    }

    public String getPriorityChoice() {
        if (null == priorityChoice) return "";
        return priorityChoice;
    }

    public void setPriorityChoice(String choice) {
        this.priorityChoice = choice;
    }
}
