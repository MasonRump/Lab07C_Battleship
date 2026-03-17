package battleship;

public class Cell {
    private boolean hasShip;
    private boolean isHit;
    private Ship ship; // 🔥 new

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

    public void setShipReference(Ship ship) {
        this.ship = ship;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean isHit() {
        return isHit;
    }

    public void markHit() {
        isHit = true;
    }
}