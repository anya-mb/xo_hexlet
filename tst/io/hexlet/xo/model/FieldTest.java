package io.hexlet.xo.model;

import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupiedException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws InvalidPointException, PointAlreadyOccupiedException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }


    @Test
    public void testGetFigureWhenFigureIsNotSet() throws InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,0);


        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThanZero() throws InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(-1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsLessThanZero() throws InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,-1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenXIsMoreThanSize() throws InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(field.getSize()+1,0);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }

    @Test
    public void testGetFigureWhenYIsMoreThanSize() throws InvalidPointException {
        final Field field = new Field(3);
        final Point inputPoint = new Point(0,field.getSize()+1);

        try {
            final Figure actualFigure = field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}

    }
}