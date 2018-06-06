package de.swtproject.doit.gui.util;

import de.swtproject.doit.core.ToDo;

import javax.swing.*;
import java.awt.*;

/**
 * The type Priority cell renderer.
 *
 * @author Ruben Maurer
 * @version 1.0
 */
public class PriorityCellRenderer extends DefaultListCellRenderer {

    /**
     * Gets list cell renderer component.
     *
     * @param list         the list
     * @param value        the value
     * @param index        the index
     * @param isSelected   the is selected
     * @param cellHasFocus the cell has focus
     * @return the list cell renderer component
     */
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        c.setBackground(Color.decode(((ToDo) value).getPriority().color));

        return c;
    }
}
