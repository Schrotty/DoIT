package de.swtproject.doit.gui.createMilestone;

import com.toedter.calendar.JDateChooser;
import de.swtproject.doit.core.IntervalType;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * The type Create to do.
 */
public class CreateMilestone extends javax.swing.JDialog {

    /**
     * The Mainsite.
     */
    private static final int fontsize = 16;

    /**
     * The Cancel button.
     */
// Variables declaration - do not modify
    private javax.swing.JButton cancelButton;
    /**
     * The Create to do label.
     */
    private javax.swing.JLabel createToDoLabel;
    /**
     * The Date to start button.
     */
    JDateChooser dateToStartButton;
    /**
     * The todo list.
     */
    JList<String> todoList;
    /**
     * The todolist panel.
     */
    private javax.swing.JPanel todoListPanel;
    /**
     * The todolist scroll pane.
     */
    private javax.swing.JScrollPane todoListScrollPane;
    /**
     * The Description panel.
     */
    private javax.swing.JPanel descriptionPanel;
    /**
     * The Description scroll pane.
     */
    private javax.swing.JScrollPane descriptionScrollPane;
    /**
     * The Description text area.
     */
    javax.swing.JTextArea descriptionTextArea;

    /**
     * The Mainpanel.
     */
    private javax.swing.JPanel mainpanel;
    /**
     * The Milestone panel.
     */

    /**
     * The Submit button.
     */
    private javax.swing.JButton submitButton;
    /**
     * The Title panel.
     */
    private javax.swing.JPanel titlePanel;
    /**
     * The Title text field.
     */
    javax.swing.JTextField titleTextField;
    /**
     * The Todo create label.
     */
    private javax.swing.JLabel todoCreateLabel;
    // End of variables declaration

    /**
     * Instantiates a new Create to do.
     */
    CreateMilestone() {
        initComponents();
    }

    /**
     * Init components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        mainpanel = new javax.swing.JPanel();
        createToDoLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        dateToStartButton = new JDateChooser();


        List<String> b = new LinkedList<String>();
        b.add("halo");
        b.add("2");

        DefaultListModel<String> lm = new DefaultListModel();

        for(int i = 0; i < 25; i++) lm.addElement("hi " + i);

        todoList = new JList<String>(lm);

        todoListPanel = new javax.swing.JPanel();
        todoListScrollPane = new javax.swing.JScrollPane();
        
        submitButton = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        titleTextField = new javax.swing.JTextField();
        descriptionPanel = new javax.swing.JPanel();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();


        todoCreateLabel = new javax.swing.JLabel();

        setTitle("Create Milestone");

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        submitButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        submitButton.setText("Submit");
        submitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(255, 255, 255)));

        titlePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null), "Title*", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));

        titleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleTextField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleTextField)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        descriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder
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

        javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
                descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionScrollPane)
        );
        descriptionPanelLayout.setVerticalGroup(
                descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(descriptionScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                                228, Short.MAX_VALUE)
        );




        dateToStartButton.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102),
                                null, null), "Date to Start", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));


        todoList.setBorder(javax.swing.BorderFactory.createTitledBorder
                (new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
                                null, new java.awt.Color(102, 102, 102),
                                null, null), "ToDos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));


        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createToDoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(descriptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(7, 7, 7)
                                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(todoList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(dateToStartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(24, Short.MAX_VALUE))))
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addComponent(createToDoLabel)
                                .addGap(38, 38, 38)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateToStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(descriptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(todoList, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(todoCreateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(todoCreateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );




        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public void setCancelButtonListener(ActionListener e) {
        cancelButton.addActionListener(e);
    }

    public void setSubmitButtonListener(ActionListener e) {
        submitButton.addActionListener(e);
    }
}