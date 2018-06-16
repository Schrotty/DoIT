package de.swtproject.doit.core;

/**
 * Class for representing a notification point.
 *
 * @author Ruben Maurer
 * @version 1.0
 */
public class NotificationPoint {

    /**
     * The display name.
     */
    private String displayName;

    /**
     * The notification point type.
     */
    private int calenderType;

    /**
     * The notification value.
     */
    private int value;

    /**
     * Get the display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Get the calendar type.
     *
     * @return the calendar type
     */
    public int getCalenderType() {
        return calenderType;
    }

    /**
     * Get the value.
     *
     * @return the value
     */
    public int getValue() {
        return value * -1;
    }

    /**
     * Get the raw value.
     *
     * @return the raw value
     */
    public int getRawValue() {
        return value;
    }

    /**
     * Create a new notification point.
     *
     * @param displayName the display name
     * @param calenderType the calendar type
     */
    private NotificationPoint(String displayName, int calenderType) {
        this.displayName = displayName;
        this.calenderType = calenderType;
    }

    /**
     * Create a new notification point.
     *
     * @param displayName the display name
     * @param calendarType the calendar type
     * @param value the value
     */
    private NotificationPoint(String displayName, String calendarType, String value) {
        this.displayName = displayName;
        this.calenderType = Integer.parseInt(calendarType);
        this.value = Integer.parseInt(value);
    }

    /**
     * Create a new notification point.
     *
     * @param point old notification point
     * @param value the value
     */
    private NotificationPoint(NotificationPoint point, String value) {
        this.displayName = point.getDisplayName();
        this.calenderType = point.getCalenderType();
        this.value = Integer.parseInt(value);
    }

    /**
     * Create a new notification point.
     *
     * @param displayName the display name
     * @param calenderType the calendar type
     */
    public static NotificationPoint create(String displayName, int calenderType) {
        return new NotificationPoint(displayName, calenderType);
    }

    /**
     * Create a new notification point.
     *
     * @param displayName the display name
     * @param calendarType the calendar type
     * @param value the value
     */
    public static NotificationPoint create(String displayName, String calendarType, String value) {
        return new NotificationPoint(displayName, calendarType, value);
    }

    /**
     * Create a new notification point.
     *
     * @param point old notification point
     * @param value the value
     */
    public static NotificationPoint create(NotificationPoint point, String value) {
        return new NotificationPoint(point, value);
    }

    /**
     * Get the string representation of this.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return displayName;
    }
}
