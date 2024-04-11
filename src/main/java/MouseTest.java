import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseTest implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse clicked " + e.toString());

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
