import javax.swing.*;
import java.awt.*;

public class BoardView implements Viewer{
    JFrame frame = new JFrame("Mancala");
    JPanel centerPanel = new JPanel();
    PitView[] p1PitViews = new PitView[6];
    PitView[] p2PitViews = new PitView[6];
    MancalaView leftMancalaView;
    MancalaView rightMancalaView;
    Viewable board;

    public BoardView(Viewable board) {
        this.board = board;

        leftMancalaView = new MancalaView(board.getPlayer(2).getName(), Color.BLUE);
        rightMancalaView = new MancalaView(board.getPlayer(1).getName(), Color.GREEN);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // end the program if the user closes the window
        frame.setLayout(new BorderLayout(0, 0));
        centerPanel.setLayout(new GridLayout(2,6, 0, 0));

        // add pitViews for player 2 to center panel
        for(int i = 5; i >= 0; i--) {
            p2PitViews[i] = new PitView(this, 1, i, Color.BLUE);
            p2PitViews[i].setCount(board.getPitCount(board.getPlayer(2), i));
            centerPanel.add(p2PitViews[i]);
        }

        // add pitViews for player 1 to center panel
        for(int i = 0; i < 6; i++) {
            p1PitViews[i] = new PitView(this, 2, i, Color.GREEN);
            p1PitViews[i].setCount(board.getPitCount(board.getPlayer(1), i));
            centerPanel.add(p1PitViews[i]);
        }

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(leftMancalaView, BorderLayout.WEST);
        frame.add(rightMancalaView, BorderLayout.EAST);

        // Top section of board
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());
        JLabel p1Label = new JLabel();
        p1Label.setText("Player 1: ");
        JLabel p2Label = new JLabel();
        p2Label.setText("Player 2: 0");
        topPanel.add(p1Label);
        topPanel.add(p2Label);
        frame.add(topPanel, BorderLayout.NORTH);

        frame.setSize(1300, 400);
        frame.setVisible(true);
    }

    public void onClick(int player, int pit) {
        System.out.printf("Click on player %d, pit %d", player, pit);
    }

    public int update(int event) {
        if(event == Event.MOVE_REQUEST) {

        }

        if(event == Event.UPDATE) {

            Player p1 = board.getPlayer(1);
            Player p2 = board.getPlayer(2);

            // update the pit views
            for (int i = 0; i < 6; i++) {
                p1PitViews[i].setCount(board.getPitCount(p1, i));
                p2PitViews[i].setCount(board.getPitCount(p2, i));
            }

            // update the Mancala views
            leftMancalaView.setCount(board.getMancalaCount(p2));
            rightMancalaView.setCount(board.getMancalaCount(p1));
        }

        return -1;
        
    }
}
