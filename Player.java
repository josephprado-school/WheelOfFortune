// a class of objects that stores player data

public class Player {
   private String playerName;
   private int playerBalance = 0;
   private int numGamesWon = 0;
   
   public Player(String playerName) {
      this.playerName = playerName;
   }
   
   public void printPlayerStats() {
      System.out.println();
      System.out.println("Player: " + playerName);
      System.out.format("Balance: $%,d%n", playerBalance);
   }

   // a method that updates the players balance; if bankrupt, multiplies balance by 0
   public void updatePlayerBalance(Game game, Wheel wheel) {
      int multiplier;
      if (wheel.getIsBankrupt()) {
          multiplier = 0;
      } else {
          multiplier = 1;
      }
      playerBalance += game.getPrizeAward();
      playerBalance *= multiplier;
  }
   
   public void setNumGamesWon() {
      numGamesWon++;
   }
   
   public String getPlayerName() {
      return playerName;
   }
   
   public int getPlayerBalance() {
      return playerBalance;
   }
   
   public int getNumGamesWon() {
      return numGamesWon;
   }
}
