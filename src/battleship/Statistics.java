package battleship;

public class Statistics {
    private int missStreak = 0;
    private int strikeCount = 0;
    private int totalHits = 0;
    private int totalMisses = 0;

    public void recordHit() {
        totalHits++;
        missStreak = 0;
    }

    public void recordMiss() {
        totalMisses++;
        missStreak++;
        if (missStreak == 5) {
            strikeCount++;
            missStreak = 0;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getTotalMisses() {
        return totalMisses;
    }

    public int getMissStreak() {
        return missStreak;
    }
}