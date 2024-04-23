public interface MancalaStrategy {
    static final int PITCOUNT = 6;
    public int getNextMove(Board board, Player player);
}
