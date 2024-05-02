public class LeastFullPitStrategy implements MancalaStrategy {

    @Override
    public int getNextMove(Board board, Player player) {
        int move = -1;
        int min = Integer.MAX_VALUE; // Start with a very high value

        // find pit with least number of stones

        for (int i = 0; i < PITCOUNT; i++) {
            int stoneCount = board.getPitCount(player, i);
            // skip empty pits
            if (stoneCount == 0)
                continue;

            if (stoneCount < min) {
                min = stoneCount;
                move = i;

            }
        }
        return move;

    }
}

