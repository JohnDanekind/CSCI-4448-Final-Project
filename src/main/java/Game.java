public class Game {
    Board board;
    Player player1 = new Player("Player A", 1);
    Player player2 = new Player("Player B", 2);
    BoardView boardView;
    Player currentPlayer;
    MancalaStrategy strategy;

    public Game() {
        board = new Board(player1, player2);
        boardView = new BoardView(board);
        board.addViewer(boardView);
        strategy = new RandomStrategy();
    }

    public void start() {
        int move;

        while( ! board.isWinner())
        {
            currentPlayer = nextPlayer();
            System.out.println("Current player is " + currentPlayer.getName());

            if(currentPlayer.getNumber() == 1) {
                // move = board.getMove(currentPlayer);
                // TODO: update this so the human player chooses the move
                move = strategy.getNextMove(board, currentPlayer);
            }
            else {
                move = strategy.getNextMove(board, currentPlayer);
            }

            System.out.println("Move is " + move);
            board.move(currentPlayer, move);

            // pause
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        System.out.println("**** Game over ****");
        System.out.println(board.getWinner().getName() + " is the winner!");

        // pause
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }



    }

    private Player nextPlayer() {

        // initial case
        if(currentPlayer == null) {
            return player2;
        }

        if(currentPlayer == player1) {
            return player2;
        }

        return player1;
    }

}
