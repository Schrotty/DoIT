package de.swtproject.doit.core;

/**
 * Enum for Task Priority.
 *
 * @author Ruben Maurer
 * @version 1.0
 */
public enum Priority {

    /**
     * Default priority.
     */
    DEFAULT("#FFFFFF", "Normal", 1),

    /**
     * Unimportant priority.
     */
    UNIMPORTANT("#4DAF7C", "Unwichtig", 0),

    /**
     * Important priority.
     */
    IMPORTANT("#F9690E", "Wichtig", 2),

    /**
     * Urgent priority.
     */
    URGENT("#9D2933", "Dringend", 3);

    /**
     * The Name.
     */
    private final String name;

    /**
     * The Color.
     */
    public final String color;

    /**
     * The weight.
     */
    private final int weight;

    /**
     * Instantiates a new Priority.
     *
     * @param color the color
     * @param name  the name
     * @param weight  the weight
     */
    Priority(String color, String name, int weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

}
