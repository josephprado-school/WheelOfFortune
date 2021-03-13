// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

// a class that retreives a random puzzle from a list

import java.util.Scanner;
import java.io.*;

public class Game {
   private int currentRound = 0;
   private int prizeWinnings;
   private boolean isGameOver = false;
   private boolean playAnotherGame = true;
   private int gameNumber = 1;
   
   Scanner keybaord = new Scanner(System.in);
   
   public void setCurrentRound() {
      currentRound++;
   }
   
   public void printSpinsRemaining(int maxNumRounds) {
      System.out.println("Number of spins remaining: " + (maxNumRounds - currentRound));
   }
   
   public void printRoundResults(boolean isGuessCorrect, int numLettersRevealed, int prizeValue) {
      System.out.println();
      System.out.println("====================================================================================================");
      if (isGuessCorrect) {
         prizeWinnings = numLettersRevealed * prizeValue;
         System.out.println("Correct! There are " + numLettersRevealed + " of those.");
         System.out.format("You just won $%,d%n", prizeWinnings);
      } else {
         prizeWinnings = 0;
         System.out.println("Sorry, there aren't any of those.");
         System.out.println("You did not win anything this round.");
      }
   }
   
   public void setIsGameOver(boolean isPuzzleSolved, int maxNumRounds) {
      int numRoundsRemaining = maxNumRounds - currentRound;
      if (isPuzzleSolved || numRoundsRemaining == 0) {
         isGameOver = true;
         currentRound = 0;
      } else {
         isGameOver = false;
      }
   }
   
   public void printGameOverMessage(boolean isPuzzleSolved, String myPuzzle, int balance, String playerName) {
      System.out.println();
      System.out.println("====================================================================================================");
      System.out.println("Answer: " + myPuzzle);
      System.out.println();
      
      if (isPuzzleSolved) {
         System.out.println(playerName + ", you win!");
         System.out.format("Your total winnings are: $%,d%n", balance);
      } else {
         System.out.println("You're out of spins! Sorry, better luck next time.");
      }
   }
   
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
   
   public boolean getIsGameOver() {
      return isGameOver;
   }
   
   public int getPrizeWinnings() {
      return prizeWinnings;
   }
   
   public boolean setPlayAnotherGame() {
      String newGame;
      do {
         System.out.println();
         System.out.println("Would you like to play another game?");
         System.out.print("Enter 'y' for yes, 'n' for no: ");
         newGame = keybaord.next().substring(0,1).toLowerCase();
         switch (newGame) {
            case "y":
               playAnotherGame = true;
               isGameOver = false;
               break;
            case "n":
               playAnotherGame = false;
               break;
            default:
               break;
         }
      } while (!newGame.equals("y") && !newGame.equals("n"));
      return playAnotherGame;
   }
}