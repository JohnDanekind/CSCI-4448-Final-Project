import javax.swing.*;
import java.awt.*;

public class BoardView implements Viewer {
    JFrame frame = new JFrame("Mancala");
    JPanel centerPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JLabel topLabel;
    PitView[] p1PitViews = new PitView[6];
    PitView[] p2PitViews = new PitView[6];
    MancalaView leftMancalaView;
    MancalaView rightMancalaView;
    Viewable board;
    String topMessage = "Mancala";
    int move;
    Color p1Color = new Color(52, 197, 23);
    Color p2Color = new Color(86, 147, 250);

    public BoardView(Viewable board) {
        this.board = board;

        // create view for left and right mancala
        leftMancalaView = new MancalaView(board.getPlayer(2).getName(), p2Color);
        rightMancalaView = new MancalaView(board.getPlayer(1).getName(), p1Color);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // end the program if the user closes the window

        // Use a "Border Layout to arrange the UI components
        frame.setLayout(new BorderLayout(0, 0));

        // center panel has a 2x6 grid layout to hold the pit views
        centerPanel.setLayout(new GridLayout(2,6, 0, 0));

        // add pitViews for player 2 to center panel, backwards for player 2, on the top row
        for(int i = 5; i >= 0; i--) {
            p2PitViews[i] = new PitView(this, 2, i, p2Color);
            p2PitViews[i].setCount(board.getPitCount(board.getPlayer(2), i));
            centerPanel.add(p2PitViews[i]);
        }

        // add pitViews for player 1 to center panel
        for(int i = 0; i < 6; i++) {
            p1PitViews[i] = new PitView(this, 1, i, p1Color);
            p1PitViews[i].setCount(board.getPitCount(board.getPlayer(1), i));
            centerPanel.add(p1PitViews[i]);
        }

        // add pits and mancalas
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(leftMancalaView, BorderLayout.WEST);
        frame.add(rightMancalaView, BorderLayout.EAST);

        // Top section of board has text to show what is going on in the game
        topPanel.setLayout(new FlowLayout());
        topLabel = new JLabel();
        topLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        topLabel.setForeground(Color.BLACK);
        topLabel.setText(topMessage);
        topPanel.add(topLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        // set the window size and make it visible
        frame.setSize(1300, 400);
        frame.setVisible(true);
    }

    // Handle mouse clicks; this will be called by a pitView
    public void onClick(int player, int pit) {
        // only update the move if the user clicked on one of their pits,
        // ignore clicks on the other player's pits or pits that have zero stones
        if(board.getCurrentPlayer().getNumber() == player) {
            // clicking on a pit with zero stones is not a valid move; ignore move if invalid
            if(board.getPitCount(board.getPlayer(player), pit) != 0) {
                // clicking on a pit with zero stones is not a valid move
                move = pit;
                board.setMove(pit);
            }
        }
    }

    // Handle events
    public int update(int event) {

        Player p1 = board.getPlayer(1);
        Player p2 = board.getPlayer(2);

        if(event == Event.WAITING_FOR_MOVE) {
            topMessage = "Waiting for " + board.getCurrentPlayer().getName() + "'s move";
            topLabel.setText(topMessage);
        }

        if(event == Event.MOVE) {
            topMessage = board.getCurrentPlayer().getName() + "'s move";
            topLabel.setText(topMessage);

            // update the pit views
            for (int i = 0; i < 6; i++) {
                p1PitViews[i].setCount(board.getPitCount(p1, i));
                p2PitViews[i].setCount(board.getPitCount(p2, i));
            }

            // update the Mancala views
            leftMancalaView.setCount(board.getMancalaCount(p2));
            rightMancalaView.setCount(board.getMancalaCount(p1));
        }

        if(event == Event.MOVE_COMPLETE) {
            waitFor(1500);

            // update the pit views
            for (int i = 0; i < 6; i++) {
                p1PitViews[i].unHighlight();
                p2PitViews[i].unHighlight();
            }
            leftMancalaView.unHighlight();
            rightMancalaView.unHighlight();
            waitFor(1000);  // let viewers see the board for a bit before updating
        }

        if(board.isWinner()) {
            // pause
            waitFor(10000); // wait 10 seconds before exiting
        }

        return 0;
    }

    private void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
