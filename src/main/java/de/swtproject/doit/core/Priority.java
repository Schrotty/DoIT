package de.swtproject.doit.core;

/**
 * Enum for Task Priority.
 *
 * @author Ruben Maurer
 * @version 1.0
 */
public enum Priority {

    /**
     * Urgent priority.
     */
    URGENT("#9D2933", "Dringend"),

    /**
     * Important priority.
     */
    IMPORTANT("#F9690E", "Wichtig"),

    /**
     * Default priority.
     */
    DEFAULT("#FFFFFF", "Normal"),

    /**
     * Unimportant priority.
     */
    UNIMPORTANT("#4DAF7C", "Unwichtig");

    /**
     * The Name.
     */
    public final String name;

    /**
     * The Color.
     */
    public final String color;

    /**
     * Instantiates a new Priority.
     *
     * @param color the color
     * @param name  the name
     */
    Priority(String color, String name) {
        this.color = color;
        this.name = name;
    }
}
