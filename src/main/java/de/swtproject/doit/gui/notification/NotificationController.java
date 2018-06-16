package de.swtproject.doit.gui.notification;

import de.swtproject.doit.core.NotificationPoint;
import de.swtproject.doit.gui.main.Mainsite;
import de.swtproject.doit.util.Settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * Controller for the notification point dialog.
 *
 * @author Ruben Maurer
 * @version 1.0
 */
public class NotificationController {

    /**
     * Dialogs parent view.
     */
    private Mainsite parent;

    /**
     * Controlled dialog.
     */
    private SetNotificationPoint dialog;

    /**
     * Create new controller.
     *
     * @param parent the dialogs parent
     */
    private NotificationController(Mainsite parent) {
        this.parent = parent;
        this.dialog = new SetNotificationPoint();
        this.fillForm();
        this.registerListener();
    }

    /**
     * Fill the form with stored values.
     */
    private void fillForm() {
        dialog.notifyTypeComb.addItem(NotificationPoint.create("Hours", Calendar.HOUR_OF_DAY));
        dialog.notifyTypeComb.addItem(NotificationPoint.create("Days", Calendar.DAY_OF_YEAR));
        dialog.notifyTypeComb.addItem(NotificationPoint.create("Week", Calendar.WEEK_OF_YEAR));
        dialog.notiyValueField.setText(String.valueOf(Settings.getNotificationPoint().getRawValue()));

        for (int i = 0; i < dialog.notifyTypeComb.getModel().getSize(); i++) {
            if (((NotificationPoint)dialog.notifyTypeComb.getModel().getElementAt(i)).getCalenderType() == Settings.getNotificationPoint().getCalenderType()) {
                dialog.notifyTypeComb.setSelectedIndex(i);
                return;
            }
        }
    }

    /**
     * Display the dialog.
     */
    public void render() {
        dialog.setLocationRelativeTo(parent);
        dialog.pack();

        dialog.setVisible(true);
    }

    /**
     * Register needed dialog listener.
     */
    private void registerListener() {
        dialog.setSubmitButtonListener(new SubmitFormListener());
        dialog.setCancelButtonListener(new CancelFormListener());
    }

    /**
     * Create a new controller.
     *
     * @param parent the dialogs parent
     * @return the recently create controller
     */
    public static NotificationController create(Mainsite parent) {
        return new NotificationController(parent);
    }

    /**
     * Listener for the dialogs submit button.
     *
     * @author Ruben Maurer
     * @version 1.0
     */
    class SubmitFormListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Settings.setNotificationPoint(
                    NotificationPoint.create((NotificationPoint) dialog.notifyTypeComb.getSelectedItem(),
                            dialog.notiyValueField.getText())
            );

            dialog.dispose();
        }
    }

    /**
     * Listener for the dialogs cancel button.
     *
     * @author Ruben Maurer
     * @version 1.0
     */
    class CancelFormListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    }
}
