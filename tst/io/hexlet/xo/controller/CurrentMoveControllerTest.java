package io.hexlet.xo.controller;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveX() {
        final WinnerController winnerController = new WinnerController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            for (int i = 0; i < 2; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(i, 0), Figure.X);
                field.setFigure(new Point(i, 1), Figure.O);
                assertEquals(Figure.X, currentMoveController.currentMove(field));

            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void currentMoveXBeginning() {
        final WinnerController winnerController = new WinnerController();
        CurrentMoveController currentMoveController = new CurrentMoveController();
        final Field field = new Field(3);
        assertEquals(Figure.X, currentMoveController.currentMove(field));

    }

    @Test
    public void currentMoveO() {
        final WinnerController winnerController = new WinnerController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            for (int i = 0; i < 3; i++) {
                final Field field = new Field(3);
                field.setFigure(new Point(i, 0), Figure.X);
                field.setFigure(new Point(i, 1), Figure.O);
                field.setFigure(new Point(i, 2), Figure.X);
                assertEquals(Figure.O, currentMoveController.currentMove(field));
            }
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void currentMoveFullField() {
        final WinnerController winnerController = new WinnerController();
        CurrentMoveController currentMoveController = new CurrentMoveController();

        try {
            final Field field = new Field(3);
            field.setFigure(new Point(0, 0), Figure.X);
            field.setFigure(new Point(0, 1), Figure.O);
            field.setFigure(new Point(0, 2), Figure.X);

            field.setFigure(new Point(1, 0), Figure.O);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(1, 2), Figure.O);

            field.setFigure(new Point(2, 0), Figure.X);
            field.setFigure(new Point(2, 1), Figure.O);
            field.setFigure(new Point(2, 2), Figure.X);

            assertNull(currentMoveController.currentMove(field));

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
    }
}