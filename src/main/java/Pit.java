public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 4;
    }

    public int getStoneCount() {
        return stoneCount;
    }

    public void addStones(int stoneCount) {
        this.stoneCount += stoneCount;
    }
}
