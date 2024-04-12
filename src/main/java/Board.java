import java.util.ArrayList;

public class Board implements Viewable{
    static final int PITCOUNT = 6;
    Player winner;

    ArrayList<Viewer> viewers = new ArrayList<>();

    Mancala p1Mancala = new Mancala();  // P1's "Mancala or store"
    Mancala p2Mancala = new Mancala();  // P2's "Mancala or store"

    Pit[] p1Pits = new Pit[PITCOUNT];
    Pit[] p2Pits = new Pit[PITCOUNT];

    Player player1;
    Player player2;

    // constructor
    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        // create pits
        for(int i = 0; i < PITCOUNT; i++) {
            p1Pits[i] = new Pit();
            p2Pits[i] = new Pit();
        }

    }

    public void move(Player player, int pit) {
        // draw the board
        updateViews();

        // take current player and select pit within the specified range of pits
        // empty all the stones from selected pit and distribute them
        int stoneCount;

        if(player.getNumber() == 1)
            stoneCount = p1Pits[pit].removeAllStones();
        else
            stoneCount = p2Pits[pit].removeAllStones();

        // keep distributing until all the stones are placed
        while(stoneCount > 0) {

            // distribute the stones in this player's pits
            for(int i = pit + 1; i < PITCOUNT && stoneCount > 0; i++) {
                if(pit >= PITCOUNT)
                    continue;

                if(player.getNumber() == 1)
                    p1Pits[i].addStones(1);
                else
                    p2Pits[i].addStones(1);
                stoneCount--;
                updateViews();
            }

            // add a stone to this player's mancala
            if(stoneCount > 0) {
                if(player.getNumber() == 1)
                    p1Mancala.addStones(1);
                else
                    p2Mancala.addStones(1);
                stoneCount--;
                updateViews();
            }

            // distribute remaining stones in the other player's pits
            if(stoneCount > 0) {
                for(int i = 0; i < PITCOUNT && stoneCount > 0; i++ ) {
                    if(player.getNumber() == 1)
                        p2Pits[i].addStones(1);
                    else
                        p1Pits[i].addStones(1);
                    stoneCount--;
                    updateViews();
                }
            }
            pit = 0; // reset the pit for the next loop
        }

        // call update on the viewers
        for(Viewer viewer : viewers) {
            viewer.update(Event.UPDATE);
        }
    }

    private void updateViews() {
        // call update on the viewers
        for(Viewer viewer : viewers) {
            viewer.update(Event.UPDATE);
        }
    }

    public int getMove(Player player) {
        int move = -1;
        // call update on the viewers
        for(Viewer viewer : viewers) {
            move = viewer.update(Event.MOVE_REQUEST);
        }

        return move;
    }

    public Player getPlayer(int playerNumber) {
        if(playerNumber == 1) {
            return player1;
        }

        if(playerNumber == 2) {
            return player2;
        }

        return null;
    }

    public void addViewer(Viewer viewer) {
        viewers.add(viewer);
    }

    public int getPitCount(Player player, int pit) {
        if(player.getNumber() == 1) {
            return p1Pits[pit].getStoneCount();
        }
        if(player.getNumber() == 2) {
            return p2Pits[pit].getStoneCount();
        }

        return -1;
    }

    public int getMancalaCount(Player player) {
        if(player.getNumber() == 1) {
            return p1Mancala.getStoneCount();
        }
        if(player.getNumber() == 2) {
            return p2Mancala.getStoneCount();
        }

        return -1;
    }

    public boolean isWinner() {
        boolean isWinner = false;
        int p1StoneCount = 0;
        int p2StoneCount = 0;

        for(int i = 0; i < PITCOUNT; i++) {
            p1StoneCount += p1Pits[i].getStoneCount();
            p2StoneCount += p2Pits[i].getStoneCount();
        }

        if(p1StoneCount == 0) {
            isWinner = true;
            winner = player1;
        }

        if(p2StoneCount == 0) {
            isWinner = true;
            winner = player2;
        }

        return isWinner;
    }

    public Player getWinner() {
        return winner;
    }
}
