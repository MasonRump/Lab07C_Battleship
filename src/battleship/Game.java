package battleship;

public class Game {
    private Board board;
    private Statistics stats;

    public Game() {
        board = new Board();
        stats = new Statistics();
    }

    public Board getBoard() {
        return board;
    }

    public Statistics getStats() {
        return stats;
    }

    public boolean checkWin() {
        return stats.getTotalHits() >= 17;
    }

    public boolean checkLoss() {
        return stats.getStrikeCount() >= 3;
    }
}