package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int size;
    private int hits;
    private List<Cell> positions;

    public Ship(int size) {
        this.size = size;
        this.hits = 0;
        this.positions = new ArrayList<>();
    }

    public void addCell(Cell cell) {
        positions.add(cell);
        cell.setShip(true);
        cell.setShipReference(this); // 🔥 important
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }
}