// a class of objects that stores player data

public class Player {
   private String name;
   private int currentBalance = 0;
   private int runningBalance = 0;
   private int numGamesWon = 0;
   
   public Player(String name) {
      this.name = name;
   }

   // a method that updates the players balance
   public void updateCurrentBalance(int prizeAward, int multiplier) {
      currentBalance += prizeAward;
      currentBalance *= multiplier;
   }

   public void updateRunningBalance() {
      runningBalance += currentBalance;
   }

   public void resetCurrentBalance() {
      currentBalance = 0;
   }
   
   public void setNumGamesWon() {
      numGamesWon++;
   }
   
   public String getName() {
      return name;
   }
   
   public int getCurrentBalance() {
      return currentBalance;
   }
   
   public int getRunningBalance() {
      return runningBalance;
   }

   public int getNumGamesWon() {
      return numGamesWon;
   }
}
