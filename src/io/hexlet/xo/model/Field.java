package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class Field {

    private static final int MIN_COORDINATE = 0;

    private final Figure[][] field;

    private final int FIELD_SIZE;

    public Field(int FIELD_SIZE) {
        this.FIELD_SIZE = FIELD_SIZE;
        this.field = new Figure[FIELD_SIZE][FIELD_SIZE];
    }

    public int getSize() {
        return FIELD_SIZE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }


        field[point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < field.length;
    }

}
