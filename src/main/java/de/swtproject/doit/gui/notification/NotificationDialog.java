package de.swtproject.doit.gui.notification;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    public JTextArea description;
    public JLabel title;


    public NotificationDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setLocationRelativeTo(this.getParent());
        this.setTitle("Need to be done");
        pack();

    }
    public void setSubmittonButtonListener(ActionListener action){
        buttonOK.addActionListener(action);

    }

}
