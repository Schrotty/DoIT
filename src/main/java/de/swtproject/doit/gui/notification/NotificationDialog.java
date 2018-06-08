package de.swtproject.doit.gui.notification;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    public JTable toDoTable;

    public NotificationDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Name");
        model.addColumn("Start");
        model.addColumn("End");
        toDoTable = new JTable(model);
        setLocationRelativeTo(this.getParent());
        pack();

    }
    public void setSubmittonButtonListener(ActionListener action){
        buttonOK.addActionListener(action);

    }


}
