import java.util.ArrayList;

public class Board implements Viewable{
    ArrayList<Viewer> viewers = new ArrayList<>();

    Mancala p1Mancala = new Mancala();
    Mancala p2Mancala = new Mancala();

    Pit[] p1Pits = new Pit[6];
    Pit[] p2Pits = new Pit[6];

    public Board() {
        // do init stuff
    }

    public void move(Player player, int pit) {
        // TODO distribute the stones according to the rules of the game

        // call update on the viewers
        for(Viewer viewer : viewers) {
            viewer.update();
        }
    }

    @Override
    public void addViewer(Viewer viewer) {
        viewers.add(viewer);
    }
}
