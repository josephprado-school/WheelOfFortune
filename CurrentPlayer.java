public class CurrentPlayer {
    private Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void updatePlayerBalance(Game game, Wheel wheel) {
        int multiplier;
        if (wheel.getIsBankrupt()) {
            multiplier = 0;
        } else {
            multiplier = 1;
        }
        player.setPlayerBalance(game.getPrizeAward(), multiplier);
    }

    public Player getPlayer() {
        return player;
    }
}