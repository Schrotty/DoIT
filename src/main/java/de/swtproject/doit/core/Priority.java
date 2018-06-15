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
    DEFAULT("#FFFFFF", "Default", 1),

    /**
     * Unimportant priority.
     */
    UNIMPORTANT("#4DAF7C", "Unimportant", 0),

    /**
     * Important priority.
     */
    IMPORTANT("#F9690E", "Important", 2),

    /**
     * Urgent priority.
     */
    URGENT("#9D2933", "Urgent", 3);

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
