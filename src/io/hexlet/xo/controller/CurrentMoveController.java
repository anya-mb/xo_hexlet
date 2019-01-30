package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int figureCounter = 0;
        final int size = field.getSize();
        final int maxCellsAvailable = size * size;

        for (int i = 0; i < size; i++) {
            figureCounter += countFiguresInTheRow(field, i);
        }

        if (figureCounter != maxCellsAvailable) {
            if (figureCounter % 2 == 1) {
                return Figure.O;
            } else {
                return Figure.X;
            }
        } else
            return null;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int figureCounter = 0;
        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null) {
                    figureCounter += 1;
                }
            } catch (final InvalidPointException e) {
                e.printStackTrace();
                //continue;
            }
        }
        return figureCounter;
    }



}
