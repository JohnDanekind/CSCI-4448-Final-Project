public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 4;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public void setStoneCount(int stoneCount) {
        this.stoneCount = stoneCount;
    }

    public void addStones(int stoneCount) {
        this.stoneCount += stoneCount;
    }

    public int removeAllStones() {
        int priorStoneCount = stoneCount;

        // clear out all stones
        stoneCount = 0;

        return priorStoneCount;
    }
}
