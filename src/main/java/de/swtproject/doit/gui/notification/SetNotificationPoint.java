package de.swtproject.doit.gui.notification;

import com.intellij.uiDesigner.core.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetNotificationPoint extends JDialog {

    SetNotificationPoint() {
        initComponents();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        contentPane = new JPanel();
        JPanel panel1 = new JPanel();
        Spacer hSpacer1 = new Spacer();
        JPanel panel2 = new JPanel();
        buttonOK = new JButton();
        buttonCancel = new JButton();
        JPanel panel3 = new JPanel();
        notifyTypeLabel = new JLabel();
        Spacer vSpacer1 = new Spacer();
        notifyTypeComb = new JComboBox();
        notifyValueLabel = new JLabel();
        notiyValueField = new JTextField();

        //======== contentPane ========
        {

            // JFormDesigner evaluation mark
            contentPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), contentPane.getBorder())); contentPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            contentPane.setLayout(new GridLayoutManager(2, 1, new Insets(10, 10, 10, 10), -1, -1));

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
                panel1.add(hSpacer1, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    null, null, null));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1, true, false));

                    //---- buttonOK ----
                    buttonOK.setText("OK");
                    panel2.add(buttonOK, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));

                    //---- buttonCancel ----
                    buttonCancel.setText("Cancel");
                    panel2.add(buttonCancel, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_FIXED,
                        null, null, null));
                }
                panel1.add(panel2, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
            }
            contentPane.add(panel1, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null));

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));

                //---- notifyTypeLabel ----
                notifyTypeLabel.setText("Notification Type");
                panel3.add(notifyTypeLabel, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
                panel3.add(vSpacer1, new GridConstraints(4, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    null, null, null));
                panel3.add(notifyTypeComb, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));

                //---- notifyValueLabel ----
                notifyValueLabel.setText("Notification Value");
                panel3.add(notifyValueLabel, new GridConstraints(2, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_FIXED,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
                panel3.add(notiyValueField, new GridConstraints(3, 0, 1, 1,
                    GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL,
                    GridConstraints.SIZEPOLICY_CAN_GROW | GridConstraints.SIZEPOLICY_WANT_GROW,
                    GridConstraints.SIZEPOLICY_FIXED,
                    null, null, null));
            }
            contentPane.add(panel3, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel notifyTypeLabel;
    public JComboBox notifyTypeComb;
    private JLabel notifyValueLabel;
    public JTextField notiyValueField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
