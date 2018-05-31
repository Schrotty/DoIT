package de.swtproject.doit.core;

enum Priority {
    URGENT("#9D2933"),
    IMPORTANT("#F9690E"),
    DEFAULT("#EEEEEE"),
    UNIMPORTANT("##4DAF7C");

    private final String color;

    Priority(String color) {
        this.color = color;
    }
}
