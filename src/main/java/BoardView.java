import javax.swing.*;
import java.awt.*;

public class BoardView implements Viewer{
    JFrame frame = new JFrame("Layout test");
    JPanel centerPanel = new JPanel();
    PitView[] pitViews = new PitView[12];
    MancalaView leftMancalaView = new MancalaView("Player 2");
    MancalaView rightMancalaView = new MancalaView("Player 1");

    public BoardView() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(0, 0));
        centerPanel.setLayout(new GridLayout(2,6, 0, 0));

        // add pitViews to center panel
        for(PitView pitView : pitViews) {
            pitView = new PitView(4, Color.BLUE);
            centerPanel.add(pitView);
        }

        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(leftMancalaView, BorderLayout.WEST);
        frame.add(rightMancalaView, BorderLayout.EAST);

        // Bottom section of board
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        bottomPanel.add(button1);
        bottomPanel.add(button2);
        bottomPanel.add(button3);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Top section of board
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout());
        JLabel p1Label = new JLabel();
        p1Label.setText("Player 1: 0");
        JLabel p2Label = new JLabel();
        p2Label.setText("Player 2: 0");
        topPanel.add(p1Label);
        topPanel.add(p2Label);
        frame.add(topPanel, BorderLayout.NORTH);

        frame.setSize(1300, 400);
        frame.setVisible(true);
    }

    public void setPitValue(int pit, int count) {
        pitViews[pit].setCount(count);
        pitViews[pit].repaint();
    }

    @Override
    public void update() {

    }
}
