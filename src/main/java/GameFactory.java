public class GameFactory {
    Board board;
    static Player player1;
    static Player player2;
    BoardView boardView;
    TextBoardView textBoardView;
    Player currentPlayer;
    MancalaStrategy p1Strategy;
    MancalaStrategy p2Strategy;

    public static Game createGame(String p1Name, String p2Name, String p1Strategy, String p2Strategy, boolean hasTextBoardView, boolean hasBoardView) {
        player1 = new Player(p1Name, 1);
        player2 = new Player(p2Name, 2);

        Game game = new Game(player1, player2);

        switch (p1Strategy) {
            case "random":
                game.setStrategy(player1, new RandomStrategy());
                break;


            case "human":
                game.setStrategy(player1, new HumanStrategy());
                break;

            case "fullestPit":
                game.setStrategy(player1, new FullestPitStrategy());
                break;

            case "leastFullPit":
                game.setStrategy(player1, new LeastFullPitStrategy());
                break;

            case "minMax":
                game.setStrategy(player1, new MinMaxStrategy());
                break;

            default:
                throw new IllegalArgumentException("Invalid strategy name");
        }

        switch (p2Strategy) {
            case "random":
                game.setStrategy(player2, new RandomStrategy());
                break;

            case "human":
                game.setStrategy(player2, new HumanStrategy());
                break;

            case "fullestPit":
                game.setStrategy(player2, new FullestPitStrategy());
                break;

            case "leastFullPit":
                game.setStrategy(player2, new LeastFullPitStrategy());
                break;

            case "minMax":
                game.setStrategy(player2, new MinMaxStrategy());
                break;
            default:
                throw new IllegalArgumentException("Invalid strategy name");
        }

        // add a text board view, if requested
        if(hasTextBoardView) {
            Board board = game.getBoard();
            board.addViewer(new TextBoardView(board));
        }

        // add a board view, if requested
        if(hasBoardView) {
            Board board = game.getBoard();
            board.addViewer(new BoardView(board));
        }

        return game;
    }
}
