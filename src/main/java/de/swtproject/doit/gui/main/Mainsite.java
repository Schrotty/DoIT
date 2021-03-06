package de.swtproject.doit.gui.main;


import de.swtproject.doit.core.Milestone;
import de.swtproject.doit.gui.edit.Edit;
import de.swtproject.doit.gui.create.CreateToDo;
import de.swtproject.doit.gui.filter.Filter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

import java.util.List;

import java.util.Objects;

/**
 * The type Mainsite.
 */
public class Mainsite extends javax.swing.JFrame {
    /**
     * The constant fontsize.
     */
    public static final int fontsize = 16;

    /**
     * Bool if prod is shown
     */
    public boolean isProd = true;

    /**
     * The Create to do frame.
     */
    protected CreateToDo createToDoFrame;
    /**
     * The Filter frame.
     */
    protected Filter filterFrame;
    /**
     * The Todo table.
     */
// Variables declaration - do not modify
    /**
     * The ToDo Tavble
     */
    javax.swing.JList todoTable;
    /**
     * The Affilation label.
     */
     javax.swing.JLabel  affilationLabel;
    /**
     * The Archiv button.
     */
    javax.swing.JButton archivButton;
    /**
     * The Milestone-Button-Panel
     */

    private javax.swing.JPanel milestoneButtonPanel;
    /**
     * The Edit-ToDo Button.
     */
    javax.swing.JButton editToDoButton;
    /**
     * The Edit-Milestone Button
     */
    javax.swing.JButton editMilestoneButton;

    /**
     * The Create milestone menu.
     */
    private javax.swing.JMenuItem createMilestoneMenu;

    /**
     * all milestones
     */
    private List<Milestone> milestones;

    /**
     * The Create notifiy point menu.
     */
    private javax.swing.JMenuItem createNotifiyPointMenu;
    /**
     * The Create to do menu.
     */
    private javax.swing.JMenuItem createToDoMenu;
    /**
     * The JSON-Data Import menu
     */
    private javax.swing.JMenuItem importJSONMenu;
    /**
     * The JSON-Data Export menu
     */
    private javax.swing.JMenuItem exportJSONMenu;
    /**
     * The Data panel.
     */
    private javax.swing.JPanel dataPanel;
    /**
     * The Date label.
     */
    javax.swing.JLabel dateLabel;
    /**
     * The Deadline label.
     */
    private javax.swing.JLabel deadlineLabel;
    /**
     * The Delete-ToDo Button.
     */

    javax.swing.JButton deleteToDoButton;
    /**
     * The Delete-Milestone Button
     */
    private javax.swing.JButton deleteMilestoneButton;

    /**
     * The Description.
     */
    javax.swing.JTextArea description;
    /**
     * The Filter button.
     */
    private javax.swing.JButton filterButton;
    /**
     * The Finish button.
     */
    javax.swing.JButton finishButton;
    /**
     * The Left panel.
     */
    private javax.swing.JPanel leftPanel;
    /**
     * The Menu create.
     */
    private javax.swing.JMenu menuButton;
    /**
     * The Menubar.
     */
    private javax.swing.JMenuBar menubar;
    /**
     * The Milestone combo box.
     */
    protected javax.swing.JComboBox<String> milestoneComboBox;
    /**
     * The Milestone label.
     */
    private javax.swing.JLabel milestoneLabel;
    /**
     * The Milestone panel.
     */
    private javax.swing.JPanel milestonePanel;
    /**
     * The Notifypoint label.
     */
    javax.swing.JLabel notifypointLabel;
    /**
     * The Prod button.
     */
    javax.swing.JButton prodButton;
    /**
     * The Right panel.
     */
    private javax.swing.JPanel rightPanel;
    /**
     * The Scroll description.
     */
    private javax.swing.JScrollPane scrollDescription;
    /**
     * The Start label.
     */
    private javax.swing.JLabel startLabel;
    /**
     * The Title.
     */
    javax.swing.JLabel title;

    /**
     * The Todo panel.
     */
    private javax.swing.JPanel todoPanel;

    /**
     * The Todo scroll pane.
     */
    private javax.swing.JScrollPane todoScrollPane;

    /**
     * The tasks priority.
     */
    javax.swing.JLabel priorityLabel;
    // End of variables declaration

    /**
     * Creates new form Main
     */
    public Mainsite() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();
    }

    /**
     * Main.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Mainsite().setVisible(true));
    }

    public void setMilestoneList(List<Milestone> l)
    {
        this.milestones = l;

        milestoneComboBox.removeAllItems();
        milestoneComboBox.addItem("No Milestone selected");
        for(Milestone m : l)
        {
            milestoneComboBox.addItem(m.toString());
        }

        for(int i = 0; i < this.milestones.size(); i++)
        {
            if(this.milestones.get(i).equals(MainController.getCurrentMilestone()))
                milestoneComboBox.setSelectedIndex(i+1);

        }



    }

    /**
     * Init components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        leftPanel = new JPanel();
        todoScrollPane = new JScrollPane();
        todoTable = new JList<>();
        filterButton = new JButton();
        prodButton = new JButton();
        archivButton = new JButton();
        milestonePanel = new JPanel();
        milestoneComboBox = new JComboBox<>();
        rightPanel = new JPanel();
        deleteToDoButton = new JButton();
        deleteMilestoneButton = new JButton();
        finishButton = new JButton();
        dataPanel = new JPanel();
        startLabel = new JLabel();
        dateLabel = new JLabel();
        milestoneLabel = new JLabel();
        affilationLabel = new JLabel();
        deadlineLabel = new JLabel();
        notifypointLabel = new JLabel();
        todoPanel = new JPanel();
        title = new JLabel();
        scrollDescription = new JScrollPane();
        description = new JTextArea();
        milestoneButtonPanel = new JPanel();
        editToDoButton = new JButton();
        editMilestoneButton = new JButton();
        menubar = new JMenuBar();
        menuButton = new JMenu();
        createToDoMenu = new JMenuItem();
        createMilestoneMenu = new JMenuItem();
        createNotifiyPointMenu = new JMenuItem();
        importJSONMenu = new JMenuItem();
        exportJSONMenu = new JMenuItem();
        priorityLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToDo Tool");

        leftPanel.setInheritsPopupMenu(true);
        leftPanel.setPreferredSize(new Dimension(200, 800));

        todoScrollPane.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        todoTable.setFont(new Font("Tahoma", 1, fontsize));
        todoScrollPane.setViewportView(todoTable);

        filterButton.setFont(new Font("Tahoma", 1, fontsize));
        filterButton.setText("Filter");
        filterButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        prodButton.setFont(new Font("Tahoma", 1, fontsize));
        prodButton.setText("Prod");
        prodButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));
        prodButton.setEnabled(false);

        archivButton.setFont(new Font("Tahoma", 1, fontsize));
        archivButton.setText("Archiv");
        archivButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        milestonePanel.setBorder(BorderFactory.createTitledBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null), "Milestones", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 1, fontsize)));

        milestoneComboBox.setFont(new Font("Tahoma", 1, fontsize));
        milestoneComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"None"}));
        milestoneComboBox.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        GroupLayout milestonePanelLayout = new GroupLayout(milestonePanel);
        milestonePanel.setLayout(milestonePanelLayout);
        milestonePanelLayout.setHorizontalGroup(
                milestonePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(milestoneComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        milestonePanelLayout.setVerticalGroup(
                milestonePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(milestoneComboBox, GroupLayout.Alignment.TRAILING)
        );

        GroupLayout leftPanelLayout = new GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(filterButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(prodButton, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(archivButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                        .addComponent(todoScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(milestonePanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(milestonePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(todoScrollPane, GroupLayout.PREFERRED_SIZE, 714, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prodButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(archivButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );

        rightPanel.setPreferredSize(new Dimension(600, 60));


        deleteToDoButton.setFont(new Font("Tahoma", 1, fontsize));
        deleteToDoButton.setText("Delete ToDo");
        deleteToDoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));


        finishButton.setFont(new Font("Tahoma", 1, fontsize));
        finishButton.setText("Finish");
        finishButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));
        finishButton.setEnabled(false);

        editToDoButton.setFont(new Font("Tahoma", 1, fontsize));
        editToDoButton.setText("Edit ToDo");
        editToDoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        deleteMilestoneButton.setFont(new Font("Tahoma", 1, fontsize));
        deleteMilestoneButton.setText("Delete Milestone");
        deleteMilestoneButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        editMilestoneButton.setFont(new Font("Tahoma", 1, fontsize));
        editMilestoneButton.setText("Edit Milestone");
        editMilestoneButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        startLabel.setFont(new Font("Tahoma", 1, fontsize)); // NOI18N
        startLabel.setText("Date to Start:");

        dateLabel.setFont(new Font("Tahoma", 1, fontsize));
        dateLabel.setText("-");

        milestoneLabel.setFont(new Font("Tahoma", 1, fontsize)); // NOI18N
        milestoneLabel.setText("Milestone:");

        affilationLabel.setFont(new Font("Tahoma", 1, fontsize));

        deadlineLabel.setFont(new Font("Tahoma", 1, fontsize)); // NOI18N
        deadlineLabel.setText("Deadline:");

        notifypointLabel.setFont(new Font("Tahoma", 1, fontsize));
        notifypointLabel.setText("-");

        priorityLabel.setFont(new Font("Tahoma", 1, fontsize));
        priorityLabel.setText("-");

        GroupLayout dataPanelLayout = new GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
                dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()

                                .addContainerGap()
                                .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(milestoneLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(startLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(affilationLabel, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(dateLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deadlineLabel)
                                .addGap(18, 18, 18)
                                .addComponent(notifypointLabel)
                                .addGap(214, 214, 214))
                        .addGap(5,5,5)
                        .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false))
                                .addComponent(milestoneButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                         );

        dataPanelLayout.setVerticalGroup(
                dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(startLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deadlineLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(notifypointLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(milestoneLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(affilationLabel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(39, Short.MAX_VALUE))
                        .addComponent(milestoneButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(dataPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                        .addGap(5,5,5)

        );

        GroupLayout milestoneButtonPanelLayout = new GroupLayout(milestoneButtonPanel);
        milestoneButtonPanel.setLayout(milestoneButtonPanelLayout);
        milestoneButtonPanelLayout.setHorizontalGroup(
                milestoneButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(milestoneButtonPanelLayout.createSequentialGroup()
                                .addComponent(editMilestoneButton, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteMilestoneButton, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        milestoneButtonPanelLayout.setVerticalGroup(
                milestoneButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(milestoneButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(editMilestoneButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteMilestoneButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        );


        title.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        title.setToolTipText("");
        //title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        scrollDescription.setBorder(null);
        scrollDescription.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));

        description.setEditable(false);
        description.setColumns(20);
        description.setFont(new Font("Tomaha", 0, fontsize)); // NOI18N
        description.setRows(5);
        description.setWrapStyleWord(true);
        description.setBorder(null);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);

        scrollDescription.setViewportView(description);

        GroupLayout todoPanelLayout = new GroupLayout(todoPanel);
        todoPanel.setLayout(todoPanelLayout);
        todoPanelLayout.setHorizontalGroup(
                todoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(todoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(todoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(title)
                                        .addComponent(priorityLabel)
                                        .addComponent(scrollDescription)))
        );
        todoPanelLayout.setVerticalGroup(
                todoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(todoPanelLayout.createSequentialGroup()
                                .addComponent(title, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityLabel)
                                .addComponent(scrollDescription, GroupLayout.PREFERRED_SIZE, 512, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );


        editToDoButton.setFont(new Font("Tahoma", 1, fontsize));
        editToDoButton.setText("Edit");
        editToDoButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, new Color(102, 102, 102), null, null));
        editToDoButton.setEnabled(false);


        GroupLayout rightPanelLayout = new GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
                rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(todoPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dataPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                               .addComponent(editToDoButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteToDoButton, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(finishButton, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)))))





                        .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
                rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(todoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                                .addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                     .addComponent(deleteToDoButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(editToDoButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(finishButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );
        menuButton.setFont(new Font("Tahoma", 1, fontsize));
        menuButton.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/HamburgerMenu.png")))); // NOI18N
        menuButton.setText("Menu");

        createToDoMenu.setFont(new Font("Tahoma", 1, fontsize));
        createToDoMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/ToDoCreate.png")))); // NOI18N
        createToDoMenu.setText("Create ToDo");
        menuButton.add(createToDoMenu);

        createMilestoneMenu.setFont(new Font("Tahoma", 1, fontsize));
        createMilestoneMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/MilesoneCreate.png")))); // NOI18N
        createMilestoneMenu.setText("Create Milestone");
        menuButton.add(createMilestoneMenu);

        createNotifiyPointMenu.setFont(new Font("Tahoma", 1, fontsize));
        createNotifiyPointMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/NotificationPointCreate.png")))); // NOI18N
        createNotifiyPointMenu.setText("Create Notification Point");
        menuButton.add(createNotifiyPointMenu);

        importJSONMenu.setFont(new Font("Tahoma", 1, fontsize));
        importJSONMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/importIcon.png")))); // NOI18N
        importJSONMenu.setText("Import JSON File");
        menuButton.add(importJSONMenu);

        exportJSONMenu.setFont(new Font("Tahoma", 1, fontsize));
        exportJSONMenu.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/exportIcon.png")))); // NOI18N
        exportJSONMenu.setText("Export JSON File");
        menuButton.add(exportJSONMenu);

        menubar.add(menuButton);

        setJMenuBar(menubar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(leftPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                                        .addComponent(rightPanel, GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public boolean isProd() {
        return this.isProd;
    }

    public void setProd(boolean isProd) {
        this.isProd = isProd;
    }

    public void setCreateToDoMenuListener(ActionListener e) {
        createToDoMenu.addActionListener(e);
    }

    public void setExportJSONMenuListener(ActionListener e) {
        exportJSONMenu.addActionListener(e);
    }

    public void setImportJSONMenuListener(ActionListener e) {
        importJSONMenu.addActionListener(e);
    }

    public void setToDoTabelListener(ListSelectionListener e) {
        todoTable.addListSelectionListener(e);
    }

    public void setCreateMilestoneListener(ActionListener e) {
        createMilestoneMenu.addActionListener(e);
    }

    public void setDeleteButtonListener(ActionListener e) {
        deleteToDoButton.addActionListener(e);
    }

    public void setArchivButtonListener(ActionListener e) {
        archivButton.addActionListener( e);
    }

    public void setEditToDoButtonListener(ActionListener e){
        editToDoButton.addActionListener(e);
    }
  
    public void setProdButtonListener(ActionListener e) {
        prodButton.addActionListener(e);

    }

    public void setEditMilestoneButtonListener(ActionListener e) {
        editMilestoneButton.addActionListener(e);

    }

    public void setDeleteMilestoneButtonListener(ActionListener e) {
        deleteMilestoneButton.addActionListener(e);

    }

    void setFinishButtonListener(ActionListener e) {
        finishButton.addActionListener(e);
    }

    public void setFilterButtonListener(ActionListener e) {
        filterButton.addActionListener(e);

    }

    public void setNotificationPointButtonListener(ActionListener e) {
        createNotifiyPointMenu.addActionListener(e);
    }

    public void setMilestoneSelectListener(ActionListener e) {
        this.milestoneComboBox.addActionListener(e);
    }
}
