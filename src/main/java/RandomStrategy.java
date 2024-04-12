public class RandomStrategy implements MancalaStrategy {
    static final int PITCOUNT = 6;

    public int getNextMove(Board board, Player player) {
        int move = (int) (Math.random() * PITCOUNT);

        while(board.getPitCount(player, move ) == 0) {
            move = (int) (Math.random() * PITCOUNT);
        }

        return move;
    }
}
