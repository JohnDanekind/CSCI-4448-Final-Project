public class FullestPitStrategy implements MancalaStrategy {

    public int getNextMove(Board board, Player player) {
        int move = 0;
        int max = 0;

        // find the pit with the greatest number of stones
        for(int i = 0; i < PITCOUNT; i++) {
            if(board.getPitCount(player, i) > max) {
                max = board.getPitCount(player, i);  // new max
                move = i; // update current best move
            }
        }

        return move;
    }
}
