public interface Viewable {
    public void addViewer(Viewer viewer);
    public int getPitCount(Player player, int pit);
    public int getMancalaCount(Player player);
    public Player getPlayer(int playerNumber);
}
