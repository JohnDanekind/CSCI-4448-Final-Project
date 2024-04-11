public class Game {
    Board board = new Board();
    Player player1 = new Player("John", 1);
    Player player2 = new Player("AI", 2);
    BoardView boardView = new BoardView();

    public void start() {
        // do game stuff
        board.addViewer(boardView);

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

}
