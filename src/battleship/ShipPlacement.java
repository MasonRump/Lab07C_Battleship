package battleship;

import java.util.Random;

public class ShipPlacement {

    private Random rand = new Random();

    public void placeShips(Board board) {
        int[] sizes = {5, 4, 3, 3, 2};

        for (int size : sizes) {
            boolean placed = false;

            while (!placed) {
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);
                boolean horizontal = rand.nextBoolean();

                if (canPlace(board, row, col, size, horizontal)) {

                    Ship ship = new Ship(size);

                    for (int i = 0; i < size; i++) {
                        int r = row + (horizontal ? 0 : i);
                        int c = col + (horizontal ? i : 0);

                        Cell cell = board.getCell(r, c);
                        ship.addCell(cell);
                    }

                    board.addShip(ship);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlace(Board board, int row, int col, int size, boolean horizontal) {
        for (int i = 0; i < size; i++) {
            int r = row + (horizontal ? 0 : i);
            int c = col + (horizontal ? i : 0);

            if (r >= 10 || c >= 10 || board.getCell(r, c).hasShip()) {
                return false;
            }
        }
        return true;
    }
}