package battleship;

public class Cell {
    private boolean hasShip;
    private boolean isHit;

    public Cell() {
        hasShip = false;
        isHit = false;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setShip(boolean value) {
        hasShip = value;
    }

    public boolean isHit() {
        return isHit;
    }

    public void markHit() {
        isHit = true;
    }
}