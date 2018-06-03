package de.swtproject.doit.gui.filter;


import com.toedter.calendar.JDateChooser;
import de.swtproject.doit.core.FilterType;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.EnumSet;

import static de.swtproject.doit.gui.main.Mainsite.fontsize;


/**
 * The type Filter.
 */
public class Filter extends javax.swing.JFrame {

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
     * The Value panel.
     */
     protected javax.swing.JPanel valuePanel;
    /**
     * The Value text field.
     */
     protected javax.swing.JTextField valueTextField;
    // End of variables declaration

    private String choice;

    /**
     * Creates new form Filter
     */
    public Filter() {
        initComponents();
        initFilterValues();
    }

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
        cancelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose Filter");
        setResizable(false);

        mainpanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Filter"));

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null), "Filter"));

        chooseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Please Choose"}));
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

        valuePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null), "Value"));

        valueTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        valueTextField.setBorder(null);

        javax.swing.GroupLayout valuePanelLayout = new javax.swing.GroupLayout(valuePanel);
        valuePanel.setLayout(valuePanelLayout);
        valuePanelLayout.setHorizontalGroup(
                valuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(valueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
        );
        valuePanelLayout.setVerticalGroup(
                valuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(valueTextField)
        );

        dateButton.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102),
                                null, null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));
        dateButton.setVisible(false);

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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(valuePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 30, Short.MAX_VALUE))
        );

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        applyButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
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
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
     * Choose combo
     *
     * @param e the evt
     */
    public void setComboBoxListener(ActionListener e) {
        chooseComboBox.addActionListener(e);
    }

    /**
     * Init ComboBox
     */
    private void initFilterValues() {
        EnumSet.allOf(FilterType.class).forEach(type -> this.chooseComboBox.addItem(type.getName()));
    }

    public JTextField getValueTextField() {
        return valueTextField;
    }

    public String getComboBoxChoice() {
        if (null == choice) return "";
        return choice;
    }

    public void setComboBoxChoice(String choice) {
        this.choice = choice;
    }
}
