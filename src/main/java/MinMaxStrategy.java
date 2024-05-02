public class MinMaxStrategy implements MancalaStrategy {

    @Override
    public int getNextMove(Board board, Player player) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;
        for(int possibleMove = 0; possibleMove < Board.PITCOUNT; possibleMove++) {
            if(board.getPitCount(player, possibleMove) > 0) {
                Board newBoard = board.copy();
                newBoard.move(possibleMove);
                int score = minimax(newBoard, player, 4, Integer.MIN_VALUE, Integer.MAX_VALUE); // Adjust depth as needed
                if(score > bestScore) {
                    bestScore = score;
                    bestMove = possibleMove;
                }
            }
        }
        return bestMove;
    }

    // minimax algorithm with alpha-beta-pruning
    private int minimax(Board board, Player player, int depth, int alpha, int beta ) {
        if(depth == 0 || board.isWinner()) {
            return evaluate(board, player);
        }
        if(board.getCurrentPlayer().getNumber() == player.getNumber()) {
            // maximizing players turn
            int maxScore = Integer.MIN_VALUE;
            for(int possibleMoves = 0; possibleMoves < Board.PITCOUNT; possibleMoves++) {
                if(board.getPitCount(player, possibleMoves) > 0) {
                    Board newBoard = board.copy();
                    newBoard.move(possibleMoves);
                    int score = minimax(newBoard, player, depth-1, alpha, beta);
                    maxScore = Math.max(maxScore, score);
                    alpha = Math.max(alpha, score);
                    if(beta <= alpha) {
                        break; // alpha cutoff
                    }

                }
            }
            return maxScore;
        }
        else {
            int minScore = Integer.MAX_VALUE;
            for(int possibleMoves = 0; possibleMoves < Board.PITCOUNT; possibleMoves++) {
                if(board.getPitCount(player, possibleMoves) > 0) {
                    Board newBoard = board.copy();
                    newBoard.move(possibleMoves);
                    int score = minimax(newBoard, player, depth-1, alpha, beta);
                    minScore = Math.min(minScore, score);
                    if(beta <= alpha) {
                        break; // cutoff
                    }

                }
            }
            return minScore; // minimizing opponents turn

        }
    }


    // utility function for the minimax
    // calculate utility based off of the difference in the number of stones between the players mancala's
    private int evaluate(Board board, Player player) {

        int playerMancalaCount = board.getMancalaCount(player);
        Player opponent;
        if (player.getNumber() == 1) {
            opponent = board.getPlayer(2);
        } else {
            opponent = board.getPlayer(1);
        }
        int opponentMancalaCount = board.getMancalaCount(opponent);

        // return the difference between player's Mancala and opponents Mancala

        int mancalaDifference = playerMancalaCount - opponentMancalaCount;

        // evaluate the number of stones in each player's pits
        // Evaluate the number of available moves for each player
        int playerAvailableMoves = 0;
        for (int pit = 0; pit < Board.PITCOUNT; pit++) {
            playerAvailableMoves += (board.getPitCount(player, pit) > 0) ? 1 : 0;
        }

        int opponentAvailableMoves = 0;
        for (int pit = 0; pit < Board.PITCOUNT; pit++) {
            opponentAvailableMoves += (board.getPitCount(opponent, pit) > 0) ? 1 : 0;
        }
        return mancalaDifference + (playerAvailableMoves - opponentAvailableMoves);


    }


}
