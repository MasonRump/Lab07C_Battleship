package battleship;

import javax.swing.*;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public String handleClick(int r, int c) {
        Cell cell = game.getBoard().getCell(r, c);

        if (cell.isHit()) return "Already";

        cell.markHit();

        if (cell.hasShip()) {
            game.getStats().recordHit();

            Ship ship = cell.getShip();
            ship.hit();

            if (ship.isSunk()) {
                return "Sunk";
            }

            return "Hit";
        } else {
            game.getStats().recordMiss();
            return "Miss";
        }
    }
}