import java.io.*;

// a class that retreives a random puzzle from a list
public class Game {
   private int currentRound = 0;
   private int prizeAward;
   private boolean isGameOver = false;
   private boolean playAnotherGame = true;
   private int gameNumber = 1;
   
   // method that increments the current round
   public void setCurrentRound() {
      currentRound++;
   }
   
   // method that prints the current status of the game (puzzle status, player balance, rounds remaining, etc.)
   public void printGameStatus(Puzzle puzzle, Player player, Settings settings) {
      System.out.println();
      System.out.println("====================================================================================================");
      System.out.println("Category: " + puzzle.getMyPuzzleCategory());
      System.out.println();
      System.out.println(puzzle.getMyPuzzleBlanks());
      System.out.println();
      System.out.println("Player: " + player.getPlayerName());
      System.out.format("Balance: $%,d%n", player.getPlayerBalance());
      System.out.println("Number of spins remaining: " + (settings.getMaxNumRounds() - currentRound));
      System.out.println("Previous incorrect guesses: " + puzzle.getGuessTracker());
   }

   // method that prints the results of the player's guess and calculates the prize to be awarded
   public void printRoundResults(Puzzle puzzle, Wheel wheel) {
      System.out.println();
      System.out.println("====================================================================================================");
      if (puzzle.getIsGuessCorrect()) {
         prizeAward = puzzle.getNumLettersRevealed() * wheel.getPrizeValue();
         System.out.println("Correct! There are " + puzzle.getNumLettersRevealed() + " of those.");
         System.out.format("You just won $%,d%n", prizeAward);
      } else {
         prizeAward = 0;
         System.out.println("Sorry, there aren't any of those.");
         System.out.println("You did not win anything this round.");
      }
   }
   
   // method that checks if game has ended (by a player winning or by the max number of rounds expiring)
   public void setIsGameOver(Puzzle puzzle, Settings settings) {
      int numRoundsRemaining = settings.getMaxNumRounds() - currentRound;
      if (puzzle.getIsPuzzleSolved() || numRoundsRemaining == 0) {
         isGameOver = true;
         currentRound = 0;
      } else {
         isGameOver = false;
      }
   }
   
   // method that prints the outcome of the game
   public void printGameOverMessage(Puzzle puzzle, Player player) {
      System.out.println();
      System.out.println("====================================================================================================");
      System.out.println("Answer: " + puzzle.getMyPuzzle());
      System.out.println();
      
      if (puzzle.getIsPuzzleSolved()) {
         System.out.println(player.getPlayerName() + ", you win!");
         System.out.format("Your total winnings are: $%,d%n", player.getPlayerBalance());
      } else {
         System.out.println("You're out of spins! Sorry, better luck next time.");
      }
   }

   // method that asks player if they would like to play another game
   public boolean setPlayAnotherGame() {
      String prompt = "Would you like to play another game? \nEnter 'y' for yes, 'n' for no";
      playAnotherGame = Keyboard.getYesOrNo(prompt);
      if (playAnotherGame) {
         isGameOver = false;
      }
      return playAnotherGame;
   }
   
   // method that saves the game results to a file
   public void saveGameStats(Player[] listOfPlayers) throws IOException {
      FileWriter outputFile = new FileWriter("GameStats.txt", true);
      outputFile.write("Game " + gameNumber + "Results: ");

      for (int i = 0; i < listOfPlayers.length; i++) {
         listOfPlayers[i].getPlayerName();
      }
      outputFile.close();
   }
   
   public int getCurrentRound() {
      return currentRound;
   }

   public int getPrizeAward() {
      return prizeAward;
   }
   
   public boolean getIsGameOver() {
      return isGameOver;
   }
}