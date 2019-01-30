package io.hexlet.xo.model;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(String name,
                  Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public String getName() {
        return name;
    }

}
