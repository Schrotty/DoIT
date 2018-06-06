package de.swtproject.doit.gui.main;

import de.swtproject.doit.core.ToDo;
import de.swtproject.doit.gui.Filter;
import de.swtproject.doit.gui.create.CreateToDo;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
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
    javax.swing.JList todoTable;
    /**
     * The Affilation label.
     */
    private javax.swing.JLabel affilationLabel;
    /**
     * The Archiv button.
     */
    private javax.swing.JButton archivButton;
    /**
     * The Edit button.
     */
    private javax.swing.JButton editButton;
    /**
     * The Create milestone menu.
     */
    private javax.swing.JMenuItem createMilestoneMenu;
    /**
     * The Create notifiy point menu.
     */
    private javax.swing.JMenuItem createNotifiyPointMenu;
    /**
     * The Create to do menu.
     */
    private javax.swing.JMenuItem createToDoMenu;
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
     * The Delete button.
     */
    private javax.swing.JButton deleteButton;
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
    private javax.swing.JButton finishButton;
    /**
     * The Left panel.
     */
    private javax.swing.JPanel leftPanel;
    /**
     * The Menu create.
     */
    private javax.swing.JMenu menuCreate;
    /**
     * The Menubar.
     */
    private javax.swing.JMenuBar menubar;
    /**
     * The Milestone combo box.
     */
    private javax.swing.JComboBox<String> milestoneComboBox;
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
    private javax.swing.JButton prodButton;
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

    /**
     * Init components.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        leftPanel = new javax.swing.JPanel();
        todoScrollPane = new javax.swing.JScrollPane();
        todoTable = new javax.swing.JList<>();
        filterButton = new javax.swing.JButton();
        prodButton = new javax.swing.JButton();
        archivButton = new javax.swing.JButton();
        milestonePanel = new javax.swing.JPanel();
        milestoneComboBox = new javax.swing.JComboBox<>();
        rightPanel = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        dataPanel = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        milestoneLabel = new javax.swing.JLabel();
        affilationLabel = new javax.swing.JLabel();
        deadlineLabel = new javax.swing.JLabel();
        notifypointLabel = new javax.swing.JLabel();
        todoPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        scrollDescription = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        editButton = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        menuCreate = new javax.swing.JMenu();
        createToDoMenu = new javax.swing.JMenuItem();
        createMilestoneMenu = new javax.swing.JMenuItem();
        createNotifiyPointMenu = new javax.swing.JMenuItem();
        priorityLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToDo Tool");

        leftPanel.setInheritsPopupMenu(true);
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 800));

        todoScrollPane.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        todoTable.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        todoScrollPane.setViewportView(todoTable);

        filterButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        filterButton.setText("Filter");
        filterButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        prodButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        prodButton.setText("Prod");
        prodButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        archivButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        archivButton.setText("Archiv");
        archivButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        milestonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null), "Milestones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, fontsize)));

        milestoneComboBox.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        milestoneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"None"}));
        milestoneComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        javax.swing.GroupLayout milestonePanelLayout = new javax.swing.GroupLayout(milestonePanel);
        milestonePanel.setLayout(milestonePanelLayout);
        milestonePanelLayout.setHorizontalGroup(
                milestonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(milestoneComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        milestonePanelLayout.setVerticalGroup(
                milestonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(milestoneComboBox, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(filterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addComponent(prodButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(archivButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(todoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(milestonePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(milestonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(todoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(prodButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(archivButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );

        rightPanel.setPreferredSize(new java.awt.Dimension(600, 32));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        deleteButton.setText("Delete");
        deleteButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        finishButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        finishButton.setText("Finish");
        finishButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        startLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize)); // NOI18N
        startLabel.setText("Date to Start:");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        dateLabel.setText("-");

        milestoneLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize)); // NOI18N
        milestoneLabel.setText("Milestone:");

        affilationLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        affilationLabel.setText("-");

        deadlineLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize)); // NOI18N
        deadlineLabel.setText("Deadline:");

        notifypointLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        notifypointLabel.setText("-");

        priorityLabel.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        priorityLabel.setText("-");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
                dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(milestoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(startLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(affilationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deadlineLabel)
                                .addGap(18, 18, 18)
                                .addComponent(notifypointLabel)
                                .addGap(214, 214, 214))
        );
        dataPanelLayout.setVerticalGroup(
                dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deadlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(notifypointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(milestoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(affilationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(39, Short.MAX_VALUE))
        );


        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setToolTipText("");
        //title.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        scrollDescription.setBorder(null);
        scrollDescription.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        description.setEditable(false);
        description.setColumns(20);
        description.setFont(new java.awt.Font("Tomaha", 0, fontsize)); // NOI18N
        description.setRows(5);
        description.setWrapStyleWord(true);
        description.setBorder(null);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);

        scrollDescription.setViewportView(description);

        javax.swing.GroupLayout todoPanelLayout = new javax.swing.GroupLayout(todoPanel);
        todoPanel.setLayout(todoPanelLayout);
        todoPanelLayout.setHorizontalGroup(
                todoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(todoPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(todoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(title)
                                        .addComponent(priorityLabel)
                                        .addComponent(scrollDescription)))
        );
        todoPanelLayout.setVerticalGroup(
                todoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(todoPanelLayout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priorityLabel)
                                .addComponent(scrollDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        editButton.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        editButton.setText("Edit");
        editButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
                rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(todoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                                .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
                rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(todoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 23, Short.MAX_VALUE)
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
        );
        menuCreate.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        menuCreate.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/HamburgerMenu.png")))); // NOI18N
        menuCreate.setText("Menu");

        createToDoMenu.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        createToDoMenu.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/ToDoCreate.png")))); // NOI18N
        createToDoMenu.setText("Create ToDo");
        menuCreate.add(createToDoMenu);

        createMilestoneMenu.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        createMilestoneMenu.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/MilesoneCreate.png")))); // NOI18N
        createMilestoneMenu.setText("Create Milestone");
        menuCreate.add(createMilestoneMenu);

        createNotifiyPointMenu.setFont(new java.awt.Font("Tahoma", 1, fontsize));
        createNotifiyPointMenu.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon/NotificationPointCreate.png")))); // NOI18N
        createNotifiyPointMenu.setText("Create Notification Point");
        menuCreate.add(createNotifiyPointMenu);

        menubar.add(menuCreate);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leftPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                                        .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    public void setCreateToDoMenuListener(ActionListener e) {
        createToDoMenu.addActionListener(e);
    }

    public void setToDoTabelListener(ListSelectionListener e) {
        todoTable.addListSelectionListener(e);
    }

    public void setDeleteButtonListener(ActionListener e) {
        deleteButton.addActionListener(e);
    }
}
