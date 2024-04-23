import java.awt.*;
import javax.swing.*;

public class MancalaView extends JPanel {
    String name;
    int count;
    Color backgroundColor;
    Color textColor = Color.BLACK;

    public MancalaView(String name, Color backgroundColor) {
        this.name = name;
        this.backgroundColor = backgroundColor;
        JLabel text = new JLabel();
        text.setFont(new Font("SansSerif", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setText(String.format(" %-30s", name));  // right pad to 30 characters to size the panel
        this.add(text);
    }

    public void setCount(int count) {

        if(count != this.count) {
            Toolkit.getDefaultToolkit().beep();
            textColor = Color.RED;
        }

        this.count = count;
        repaint();
    }

    public void unHighlight() {
        textColor = Color.BLACK;
        repaint();
    }

    /**
     * Called by the runtime system whenever the panel needs painting.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        setBackground(backgroundColor);

        Point center = new Point(getWidth() / 2, getHeight() / 2);
        int radius = 60;
        int diameter = radius * 2;

        // draw oval
        g2d.setColor(Color.WHITE);
        g2d.fillOval(center.x - radius, center.y - radius * 2, diameter, diameter * 2);

        // Set font and color, draw text
        Font font = new Font("SansSerif", Font.BOLD, 60);
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
