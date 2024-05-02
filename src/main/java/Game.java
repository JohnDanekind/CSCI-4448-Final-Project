public class Game {
    Board board;
    Player player1;
    Player player2;
    BoardView boardView;
    TextBoardView textBoardView;
    Player currentPlayer;
    MancalaStrategy p1Strategy;
    MancalaStrategy p2Strategy;
    Player winner;


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
            currentPlayer = board.getCurrentPlayer();

            if(currentPlayer.getNumber() == 1) {
                // get move for player 1
                move = p1Strategy.getNextMove(board, currentPlayer);
            }
            else {
                move = p2Strategy.getNextMove(board, currentPlayer);
            }

            // do the move
            board.move(move);
        }

        // game is over
        winner = board.getWinner();
    }

    public int getWinnerPlayerNumber() {
        // if the game is a tie, winner will be null
        if(winner == null) {
            // return 0 to indicate a tie
            return 0;
        }

        // return winner's player number
        return winner.getNumber();

    }

}
