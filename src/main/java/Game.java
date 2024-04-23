public class Game {
    Board board;
    Player player1 = new Player("Fullest pit", 1);
    Player player2 = new Player("Random", 2);
    BoardView boardView;
    TextBoardView textBoardView;
    Player currentPlayer;
    MancalaStrategy randomStrategy;
    MancalaStrategy minMaxStrategy;
    MancalaStrategy fullestPitStrategy;

    // TODO: turn this into a factory pattern
    public Game() {
        // the board
        board = new Board(player1, player2);

        // board views
        textBoardView = new TextBoardView(board);
        board.addViewer(textBoardView);
        boardView = new BoardView(board);
        board.addViewer(boardView);

        // strategies
        randomStrategy = new RandomStrategy();
        minMaxStrategy = new MinMaxStrategy();
        fullestPitStrategy = new FullestPitStrategy();
    }

    public void start() {
        int move;

        // keep looping until there is a winner
        while( ! board.isWinner())
        {
            currentPlayer = nextPlayer();  // switch players

            if(currentPlayer.getNumber() == 1) {
                // get move from the human player
                move = board.getMove(currentPlayer);

                //move = fullestPitStrategy.getNextMove(board, currentPlayer);
            }
            else {
                move = randomStrategy.getNextMove(board, currentPlayer);
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
