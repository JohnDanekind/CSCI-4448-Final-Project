import java.util.ArrayList;

public class Board implements Viewable, Cloneable {
    static final int PITCOUNT = 6;
    Player winner;
    Player currentPlayer;
    int currentMove = -1;

    ArrayList<Viewer> viewers = new ArrayList<>();

    Mancala p1Mancala;  // P1's "Mancala or store"
    Mancala p2Mancala;  // P2's "Mancala or store"

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

        p1Mancala = new Mancala();
        p2Mancala = new Mancala();
    }

    public void move(Player player, int pit) {
        currentPlayer = player;
        currentMove = pit;

        // draw the board
        updateViews(player);

        // take current player and select pit within the specified range of pits
        // empty all the stones from selected pit and distribute them
        int stoneCount;

        // remove all the stones from the chosen pit
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

                // if the last stone is placed in an empty pit on the player's side, move all
                // stones from the opposite pit on the other player's side to this player's mancala
                if(stoneCount == 0) {
                    int oppositePit = 5 - i;  // calculate opposite pit
                    int oppositePitCount;
                    if(player.getNumber() == 1 && p1Pits[i].getStoneCount() == 1) {

                        oppositePitCount = p2Pits[oppositePit].removeAllStones();
                        p1Mancala.addStones(oppositePitCount);
                        System.out.println("******* Empty pit bonus! ********");
                    }
                    else if (p2Pits[i].getStoneCount() == 1) {

                        oppositePitCount = p1Pits[oppositePit].removeAllStones();
                        p2Mancala.addStones(oppositePitCount);
                        System.out.println("******* Empty pit bonus! ********");
                    }
                }

                updateViews(player);
            }

            // if there are still stones to distribute, add a stone to this player's mancala
            if(stoneCount > 0) {
                if(player.getNumber() == 1)
                    p1Mancala.addStones(1);
                else
                    p2Mancala.addStones(1);
                stoneCount--;
                updateViews(player);
            }

            // if there are still stones to distribute, put the remaining stones in the other player's pits
            if(stoneCount > 0) {
                for(int i = 0; i < PITCOUNT && stoneCount > 0; i++ ) {
                    if(player.getNumber() == 1)
                        p2Pits[i].addStones(1);
                    else
                        p1Pits[i].addStones(1);
                    stoneCount--;
                    updateViews(player);
                }
            }
            pit = 0; // reset the pit for the next loop
        }

        // Tell the views the move is complete
        for(Viewer viewer : viewers) {
            viewer.update(Event.MOVE_COMPLETE);
        }
    }

    // Return a deep copy of the pits and mancalas of this board
    // Note: this does not copy the viewers
    public Board copy()  {
        Board boardCopy = null;

        Player newPlayer1 = new Player(player1.getName(), 1);
        Player newPlayer2 = new Player(player2.getName(), 1);
        boardCopy = new Board(newPlayer1, newPlayer2);

        // perform deep copy of pits
        for(int i = 0; i < PITCOUNT; i++) {
            boardCopy.setPitCount(player1, i, p1Pits[i].getStoneCount());
            boardCopy.setPitCount(player2, i, p2Pits[i].getStoneCount());
        }

        // copy mancala values
        boardCopy.setMancalaCount(player1, p1Mancala.getStoneCount());
        boardCopy.setMancalaCount(player2, p2Mancala.getStoneCount());

        // set current player
        boardCopy.setCurrentPlayer(currentPlayer);

        return boardCopy;
    }

    private void updateViews(Player player) {
        // call update on the viewers
        for(Viewer viewer : viewers) {
            viewer.update(Event.MOVE);
        }
    }

    public int getMove(Player player) {
        currentPlayer = player;

        // call update on the viewers, let them know the board is waiting for a move
        for(Viewer viewer : viewers) {
            viewer.update(Event.WAITING_FOR_MOVE);
        }

        currentMove = -1;

        // wait for the UI to call back, in another thread, to setMove()
        while(currentMove == -1) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        return currentMove;
    }

    public void setMove(int move) {
        this.currentMove = move;
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

    public void setPitCount(Player player, int pit, int count) {
        if(player.getNumber() == 1) {
            p1Pits[pit].setStoneCount(count);
        }
        if(player.getNumber() == 2) {
            p2Pits[pit].setStoneCount(count);
        }
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

    public void setMancalaCount(Player player, int count) {
        if(player.getNumber() == 1) {
            p1Mancala.setStoneCount(count);
        }
        if(player.getNumber() == 2) {
            p2Mancala.setStoneCount(count);
        }
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentMove() {
        return currentMove;
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
