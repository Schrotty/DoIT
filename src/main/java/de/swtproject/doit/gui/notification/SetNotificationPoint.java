package de.swtproject.doit.gui.notification;

import javax.swing.*;
import java.awt.event.*;

public class SetNotificationPoint extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel notifyTypeLabel;
    public JComboBox notifyTypeComb;
    public JTextField notiyValueField;
    private JLabel notifyValueLabel;

    SetNotificationPoint() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    void setSubmitButtonListener(ActionListener e) {
        buttonOK.addActionListener(e);
    }

    void setCancelButtonListener(ActionListener e) {
        buttonCancel.addActionListener(e);
    }
}
