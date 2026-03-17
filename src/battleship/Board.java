package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Cell[][] grid;
    private List<Ship> ships;
    private Random rand;

    public Board() {
        grid = new Cell[10][10];
        ships = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                grid[i][j] = new Cell();

        ShipPlacement placement = new ShipPlacement();
        placement.placeShips(this);
    }

    public Cell getCell(int r, int c) {
        return grid[r][c];
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public Ship getShipAt(int r, int c) {
        for (Ship s : ships) {
            if (s.isSunk()) continue;
            // brute check
            if (grid[r][c].hasShip()) return s;
        }
        return null;
    }
}