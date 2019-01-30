package io.hexlet.xo.view;

import io.hexlet.xo.controller.CurrentMoveController;
import io.hexlet.xo.controller.MoveController;
import io.hexlet.xo.controller.WinnerController;
import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.exceptions.InvalidPointException;
import io.hexlet.xo.model.exceptions.PointAlreadyOccupiedException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s", game.getName());
        System.out.println("");

        final Field field = game.getField();
        for (int x = 0; x < field.getSize(); x++) {
            if (x != 0) {
                printSeparator();
            }
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.format("Winner is %s\n", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            System.out.println("No winner and no moves left");
            return false;
        }



        System.out.format("Please enter move point for figure %s\n", currentFigure);

        final Point point = askPoint();
        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (InvalidPointException | PointAlreadyOccupiedException e) {
            //e.printStackTrace();
            System.out.println("Point is invalid");
        }
        return true;

    }

    private Point askPoint() {
        return new Point(askCoordinate("i") - 1, askCoordinate("j") - 1);
    }

    private int askCoordinate(final String coordinate) {
        System.out.format("Please input %s ", coordinate);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("O_O not a number");
            return askCoordinate(coordinate);
        }
    }

    private void printLine(final Field field,
                           final int x) {

        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0) {
                System.out.print("|");
            }
            System.out.print(" ");
            final Figure figure;

            try {
                figure = field.getFigure(new Point(x,y));
                System.out.print(figure != null ? figure : " ");

            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(" ");

        }
        System.out.println("");

    }

    private void printSeparator() {

        System.out.println("-----------");
    }

}
