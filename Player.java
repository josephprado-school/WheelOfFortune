// a class of objects that stores player data

public class Player {
   private String playerName;
   private int playerBalance = 0;
   private int numGamesWon = 0;
   
   public Player(String playerName) {
      this.playerName = playerName;
   }

   // a method that updates the players balance
   public void setPlayerBalance(int prizeAward, int multiplier) {
      playerBalance += prizeAward;
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
