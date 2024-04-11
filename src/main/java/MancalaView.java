import java.awt.*;
import javax.swing.*;

public class MancalaView extends JPanel {
    String name;
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public MancalaView(String name) {
        this.name = name;
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(200, 200));
        JLabel text = new JLabel();
        text.setFont(new Font("SansSerif", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setText("       " + name + "       ");

        JLabel countText = new JLabel("0", SwingConstants.CENTER);
        countText.setFont(new Font("SansSerif", Font.BOLD, 28));
        countText.setForeground(Color.BLACK);
        countText.setText(Integer.toString(count));

        this.add(text, BorderLayout.NORTH);
        this.add(countText, BorderLayout.CENTER);
    }

    /**
     * Called by the runtime system whenever the panel needs painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        setBackground(Color.BLUE);

        var center = new Point(getWidth() / 2, getHeight() / 2);
        var radius = getWidth() / 2 - 20;  // 20 for the gap
        var diameter = radius * 2;

        // draw circle
        g2d.setColor(Color.WHITE);
        g2d.fillOval(center.x - radius, center.y - radius * 2, diameter, diameter * 2);
    }
}
