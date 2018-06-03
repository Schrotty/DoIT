package de.swtproject.doit.core;

/**
 * The enum Filter type.
 */
public enum FilterType {

    /**
     * Title filter type.
     */
    TITLE("Title"),

    /**
     * Start Date filter Type
     */
    START("Date to Start"),

    /**
     * Deadline filter type.
     */
    DEADLINE("Deadline"),

    /**
     * Day filter type.
     */
    PRIORITY("Priority");

    private String name;

    FilterType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
