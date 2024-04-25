import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {



   // SINGLETON we only want the move to happen once
    private static final MouseHandler mouseHandlerInstance = new MouseHandler();

    // private constructor
    private MouseHandler() {

    }

    // factory method - returns the same instance of MouseHandler every time
    public static MouseHandler getInstance() {
        return mouseHandlerInstance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        PitView pitView;
        if(e.getComponent() instanceof PitView) {
            pitView = (PitView) e.getComponent();
            pitView.onClick();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
