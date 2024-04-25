public class Game {
    Board board;
    Player player1;
    Player player2;
    BoardView boardView;
    TextBoardView textBoardView;
    Player currentPlayer;
    MancalaStrategy p1Strategy;
    MancalaStrategy p2Strategy;

    // TODO: turn this into a factory pattern
    public Game(Player player1, Player player2) {
        // the board
        this.player1 = player1;
        this.player2 = player2;
        board = new Board(player1, player2);
    }

    public void setStrategy(Player player, MancalaStrategy strategy) {
        if(player.getNumber() == 1) {
            this.p1Strategy = strategy;
        }
        else {
            this.p2Strategy = strategy;
        }
    }

    public Board getBoard() {
        return board;
    }

    public void start() {
        int move;

        // keep looping until there is a winner
        while( ! board.isWinner())
        {
            currentPlayer = nextPlayer();  // switch players

            if(currentPlayer.getNumber() == 1) {
                // get move for player 1
                move = p1Strategy.getNextMove(board, currentPlayer);
            }
            else {
                move = p2Strategy.getNextMove(board, currentPlayer);
            }

            // do the move
            board.move(currentPlayer, move);
        }

        // game is over
    }

    private Player nextPlayer() {

        // initial case
        if(currentPlayer == null) {
            return player1;
        }

        if(currentPlayer == player1) {
            return player2;
        }

        return player1;
    }

}
