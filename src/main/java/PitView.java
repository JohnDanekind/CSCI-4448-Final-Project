import java.awt.*;
import javax.swing.*;

public class PitView extends JPanel {

    int count = 0;
    Color pitColor = Color.WHITE;
    Color textColor = Color.BLACK;
    Color backgroundColor;
    int number;
    int player;
    BoardView boardView;

    public PitView(BoardView boardView, int player, int number, Color backgroundColor) {
        this.boardView = boardView;
        this.player = player;
        this.number = number;
        this.backgroundColor = backgroundColor;

        JLabel label = new JLabel(" ", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        label.setForeground(Color.BLACK);
        label.setText(Integer.toString(number));
        add(label);

        // add listener so this code can receive a callback when the user clicks on a pit
        addMouseListener(new MouseHandler());
    }

    public void setCount(int count) {
        this.count = count;
        repaint();
    }

    public void onClick() {
        boardView.onClick(player, number);
    }

    /**
     * Called by the runtime system whenever the panel needs painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        setBackground(backgroundColor);

        // calculate where to put the circle
        var center = new Point(getWidth() / 2, getHeight() / 2);
        var radius = getWidth() / 2 - 20;  // 20 for the gap
        var diameter = radius * 2;

        // draw circle
        g2d.setColor(pitColor);
        g2d.fillOval(center.x - radius, center.y - radius, diameter, diameter);

        // Set font and color
        Font font = new Font("SansSerif", Font.BOLD, 48);
        g2d.setFont(font);
        g2d.setColor(textColor);
        Rectangle rectangle = new Rectangle(getWidth(), getHeight());
        drawCenteredString(g2d, Integer.toString(count), rectangle, font);
    }

    /**
     * Draw a String centered in the middle of a Rectangle.
     *
     * @param g The Graphics instance.
     * @param text The String to draw.
     * @param rect The Rectangle to center the text in.
     */
    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

}