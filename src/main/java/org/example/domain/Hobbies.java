package org.example.domain;

public enum Hobbies {
    SWIMMING("Swimming"),
    RUNNING("Running"),
    WALKING("Walking"),
    DANCING("Dancing"),
    PLAYING("Playing"),
    SLEEPING("Sleeping");

    private final String name;

    public String getName() {
        return name;
    }

    Hobbies(String name) {
        this.name = name;
    }
}
