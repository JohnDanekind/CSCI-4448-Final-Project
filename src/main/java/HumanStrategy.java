public class HumanStrategy implements MancalaStrategy {

    public int getNextMove(Board board, Player player) {
        return board.getMove(player);
    }
}
