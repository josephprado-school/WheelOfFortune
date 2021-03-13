// a class that configures the game's various settings

public class Settings {
   private int numPlayers = 0;
   private int maxNumRounds = 25;
   private int prizeValueIncrement = 1000;
   private boolean allowBankruptcy = true;
   private Player[] listOfPlayers;
   
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
   
   // intial game setup; sets number of players, number of rounds, prize increment, and enables/disables bankruptcy
   public void gameSetup() {
      System.out.println("Let's begin.");
      setNumPlayers();
      createNewPlayers(numPlayers);
      String prompt = "Would you like to change the game's defualt settings? \nEnter 'y' for yes, 'n' for no";
      boolean changeSettings = Keyboard.getYesOrNo(prompt);
      if (changeSettings) {
         setMaxNumRounds();
         setPrizeValueIncrement();
         setAllowBankruptcy();
      }
   }
   
   // method that takes number of players and creates an array of players
   public void createNewPlayers(int numOfPlayers) {
      listOfPlayers = new Player[numOfPlayers];
      for (int i = 0; i < numOfPlayers; i++) {
         String name = Keyboard.getString("Player" + (i + 1) + " Name");
         listOfPlayers[i] = new Player(name);
      }
   }
   
   // method that sets number of players
   public void setNumPlayers() {
      String prompt = "How many players will be playing? \nEnter an integer from 1-4";
      numPlayers = Keyboard.getInteger(prompt, 1, 4);
   }
   
   // method that sets maximum number of rounds
   public void setMaxNumRounds() {
      String prompt = "Maximum Number of Rounds \nEnter an integer from 1-25";
      maxNumRounds = Keyboard.getInteger(prompt, 1, 25);
   }
   
   // method that sets prize value increment
   public void setPrizeValueIncrement() {
      String prompt = "Prize Value Increment \nEnter and integer value >= 100";
      prizeValueIncrement = Keyboard.getInteger(prompt, 100);
   }
   
   // method that enables/disables the bankruptcy position on the wheel
   public void setAllowBankruptcy() {
      String prompt = "Allow Bankruptcy? \nEnter 'y' for yes, 'n' for no";
      allowBankruptcy = Keyboard.getYesOrNo(prompt);
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