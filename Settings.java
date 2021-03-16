// a class that configures the game's various settings

public class Settings {
   private int numPlayers = 0;
   private int maxNumRounds = 25;
   private int prizeValueIncrement = 1000;
   private boolean allowBankruptcy = true;
   private Player[] listOfPlayers;
   Keyboard keyboard = new Keyboard();
   
   // print game rules
   public void printGameRules() {
      System.out.println("Hello and welcome to Wheel of Fortune!");
      System.out.println();
   
      System.out.println("In this game, you will attempt to solve a word puzzle and win prizes along the way.");
      System.out.println("The rules of the game are as follows:");
      System.out.println();
   
      System.out.println("1. At the beginning of each turn, you will spin the wheel for a chance to earn a random cash prize.");
      System.out.println("2. After spinning, you will have one attempt to either:");
      System.out.println("\ta) Solve the puzzle, or");
      System.out.println("\tb) Guess whether a certain letter is contained in the hidden phrase.");
      System.out.println("3. If you guess correctly, the cash prize will be added to your balance and your turn will begin again.");
      System.out.println("4. Your turn will continue unitl you guess an incorrect letter, at which point it will become the next player's turn (if applicable),");
      System.out.println("   or until you successfully solve the puzzle, at whcih point the game will end.");
      System.out.println();
   
      System.out.println("Good Luck!");
      System.out.println();
   }
   
   // intial game setup; sets number of players and allows user to change default game settings
   public void gameSetup() {
      System.out.println("Let's begin.");

      // player creation
      numPlayers = keyboard.getInteger("How many players will be playing?", 1, 4);
      listOfPlayers = new Player[numPlayers];
      for (int i = 0; i < numPlayers; i++) {
         listOfPlayers[i] = new Player(keyboard.getString("Player" + (i + 1) + " Name"));
      }
      
      // optional settings configuration
      boolean changeSettings = keyboard.getYesOrNo("Would you like to change the game's defualt settings?");
      if (changeSettings) {
         maxNumRounds = keyboard.getInteger("Maximum Number of Rounds", 1, 25);
         prizeValueIncrement = keyboard.getInteger("Prize Value Increment", 100);
         allowBankruptcy = keyboard.getYesOrNo("Allow Bankruptcy?");
      }
   }
   
   public int getNumPlayers() {
      return numPlayers;
   }
   
   public int getMaxNumRounds() {
      return maxNumRounds;
   }
   
   public int getPrizeValueIncrement() {
      return prizeValueIncrement;
   }
   
   public boolean getAllowBankruptcy() {
      return allowBankruptcy;
   }
   
   public Player[] getListOfPlayers() {
      return listOfPlayers;
   }
}