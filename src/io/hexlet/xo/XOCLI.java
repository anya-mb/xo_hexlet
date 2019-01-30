package io.hexlet.xo;

import io.hexlet.xo.model.Field;
import io.hexlet.xo.model.Figure;
import io.hexlet.xo.model.Game;
import io.hexlet.xo.model.Player;
import io.hexlet.xo.view.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final String name1 = "Anna";
        final String name2 = "Anatolii";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name1, Figure.O);

        final Field field = new Field(3);

        final String gameName = "XOXOXO";

        final Game gameXO = new Game(players, field, gameName);

        final ConsoleView consoleView = new ConsoleView();

        consoleView.show(gameXO);

        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

}
