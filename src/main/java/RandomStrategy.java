public class RandomStrategy implements MancalaStrategy {

    public int getNextMove(Board board, Player player) {
        int move = (int) (Math.random() * PITCOUNT); // get random move

        // if the pit has zero stones, chose a new pit
        // keep doing this until a non-empty pit is found
        while(board.getPitCount(player, move ) == 0) {
            move = (int) (Math.random() * PITCOUNT);
        }

        return move;
    }
}
