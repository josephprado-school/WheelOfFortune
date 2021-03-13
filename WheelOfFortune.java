// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

/*
   To do:
   1. print out game results to a file
   
   known bugs:
   1. in settings, createNewPlayers method has a problem with spaces.
      if you type a space in the name (e.g., first last), it takes the text before the space as the current player's name
      and uses everything after the space as the next players name
*/


import java.io.*;

public class WheelOfFortune {
   public static void main(String[] args) throws IOException {
      
      // object dclaration
      Settings settings = new Settings();
      Game game = new Game();
      Wheel wheel = new Wheel();
      Puzzle puzzle = new Puzzle();
      Player[] listOfPlayers;
      settings.printGameRules();
      
      // game settings and wheel configuration
      settings.gameSetup();
      listOfPlayers = settings.getListOfPlayers();
      wheel.createWheelPrizes(settings.getPrizeValueIncrement(), settings.getAllowBankruptcy());
      int playerIndex = 0;
      
      do {
         puzzle.generatePuzzle("ListOfPuzzles.csv");
         while (!game.getIsGameOver()) {
            for (playerIndex = 0; playerIndex < listOfPlayers.length; playerIndex++) {
               do {
                  puzzle.printMyPuzzleStatus();
                  listOfPlayers[playerIndex].printPlayerStats();
                  game.printSpinsRemaining(settings.getMaxNumRounds());
                  puzzle.printGuessTracker();
                  wheel.spinTheWheel();
                  game.setCurrentRound();
                  
                  if (!wheel.getIsBankrupt()) {
                     puzzle.printMyPuzzleStatus();
                     listOfPlayers[playerIndex].printPlayerStats();
                     game.printSpinsRemaining(settings.getMaxNumRounds());
                     puzzle.printGuessTracker();
                     puzzle.checkGuess();
                     game.printRoundResults(puzzle.getIsGuessCorrect(), puzzle.getNumLettersRevealed(), wheel.getPrizeValue());
                  } else {
                     System.out.println("\nSorry, you lose a turn.");
                  }
                  
                  listOfPlayers[playerIndex].setPlayerBalance(game.getPrizeWinnings(), wheel.getIsBankrupt());
                  System.out.format("Your total winnings are: $%,d%n", listOfPlayers[playerIndex].getPlayerBalance());
                  game.setIsGameOver(puzzle.getIsPuzzleSolved(), settings.getMaxNumRounds());
               } while (puzzle.getIsGuessCorrect() && !wheel.getIsBankrupt() && !game.getIsGameOver());
               if (game.getIsGameOver()) {
                  break;
               }
            }
         }
         game.printGameOverMessage(
            puzzle.getIsPuzzleSolved(),
            puzzle.getMyPuzzle(),
            listOfPlayers[playerIndex].getPlayerBalance(),
            listOfPlayers[playerIndex].getPlayerName()
         );
         System.out.println();
         if (puzzle.getIsPuzzleSolved()) {
            listOfPlayers[playerIndex].setNumGamesWon(1);
         }
         for (int i = 0; i < settings.getNumPlayers(); i++) {
            System.out.format(listOfPlayers[i].getPlayerName() + " Cash Won: $%,d", listOfPlayers[i].getPlayerBalance());
            System.out.println("; Games Won: " + listOfPlayers[i].getNumGamesWon());
         }
      } while (game.setPlayAnotherGame());
   }
}