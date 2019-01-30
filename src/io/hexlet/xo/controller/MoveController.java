package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                      PointAlreadyOccupiedException {

        if (field.getFigure(point) != null ) {
            throw new PointAlreadyOccupiedException();
        }

        field.setFigure(point, figure);

    }
    

    
}
