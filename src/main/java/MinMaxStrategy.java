public class MinMaxStrategy implements MancalaStrategy {

    public int getNextMove(Board board, Player player) {

        // Make a copy of the current board
        Board newBoard = board.copy();

        // TODO: remove this is placeholder code that returns a random move, replace with MINMAX code
        int move = (int) (Math.random() * PITCOUNT);
        while(board.getPitCount(player, move ) == 0) {
            move = (int) (Math.random() * PITCOUNT);
        }

        return move;
    }



}
