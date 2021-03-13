// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

import java.io.*;

public class WheelOfFortune {
   public static void main(String[] args) throws IOException {
      
      // object dclaration
      Settings settings = new Settings();
      Game game = new Game();
      Wheel wheel = new Wheel();
      Puzzle puzzle = new Puzzle();
      Player[] listOfPlayers;
      CurrentPlayer currentPlayer = new CurrentPlayer();
      settings.printGameRules();
      
      // game settings and wheel configuration
      settings.gameSetup();
      listOfPlayers = settings.getListOfPlayers();
      wheel.createWheelPrizes(settings);
      int playerIndex = 0;
      
      // main program loop; continues unitl player chooses not to play another game
      do {
         puzzle.generatePuzzle("ListOfPuzzles.csv");

         // game loop; continues until puzzle is solved or max number of rounds have expired
         while (!game.getIsGameOver()) {

            // player loop; loops through each player until game is over
            for (playerIndex = 0; playerIndex < listOfPlayers.length; playerIndex++) {
               currentPlayer.setPlayer(listOfPlayers[playerIndex]);

               // round loop; each player continues his/her round until one of the following:
               //    a. player makes a wrong guess
               //    b. player goes bankrupt
               //    c. game is over
               do {
                  game.printGameStatus(puzzle, currentPlayer.getPlayer(), settings);
                  wheel.spinTheWheel();
                  game.setCurrentRound();
                  if (!wheel.getIsBankrupt()) {
                     game.printGameStatus(puzzle, currentPlayer.getPlayer(), settings);
                     puzzle.checkGuess();
                     game.printRoundResults(puzzle, wheel);
                  } else {
                     System.out.println("\nSorry, you lose a turn.");
                  }
                  currentPlayer.updatePlayerBalance(game, wheel);
                  System.out.format("Your total winnings are: $%,d%n", currentPlayer.getPlayer().getPlayerBalance());
                  game.setIsGameOver(puzzle, settings);
               } while (puzzle.getIsGuessCorrect() && !wheel.getIsBankrupt() && !game.getIsGameOver());

               if (game.getIsGameOver()) {
                  break;
               }
            }
         }
         game.printGameOverMessage(puzzle, currentPlayer.getPlayer());
         System.out.println();
         if (puzzle.getIsPuzzleSolved()) {
            currentPlayer.getPlayer().setNumGamesWon(1);
         }
         for (int i = 0; i < settings.getNumPlayers(); i++) {
            System.out.format(listOfPlayers[i].getPlayerName() + " Cash Won: $%,d", listOfPlayers[i].getPlayerBalance());
            System.out.println("; Games Won: " + listOfPlayers[i].getNumGamesWon());
         }
      } while (game.setPlayAnotherGame());
   }
}