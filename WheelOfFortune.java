// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

import java.io.*;

public class WheelOfFortune {
   public static void main(String[] args) throws IOException {
      
      // object dclaration
      Settings settings = new Settings();
      Player[] listOfPlayers;
      Wheel wheel = new Wheel();
      Puzzle puzzle = new Puzzle();
      Game game = new Game();
      
      // game rules, configure settings, and setup the wheel
      settings.printGameRules();
      settings.gameSetup();
      listOfPlayers = settings.getListOfPlayers();
      wheel.createWheelPrizes(settings);
      int currentPlayer = 0;
      
      // main program loop (multiple games)
      // continues unitl player chooses not to play another game
      do {
         puzzle.generatePuzzle("ListOfPuzzles.csv");
         // game loop
         // continues until game is over (puzzle is solved or max number of rounds have expired)
         while (!game.getIsGameOver()) {
            // player loop
            // loops through each player until game is over
            for (currentPlayer = 0; currentPlayer < listOfPlayers.length; currentPlayer++) {
               // round loop
               // each player continues their round until one of the following:
               // a) player makes a wrong guess, b) player goes bankrupt, or c) game is over
               do {
                  game.playRound(puzzle, listOfPlayers[currentPlayer], settings, wheel);
               } while (puzzle.getIsGuessCorrect() && !wheel.getIsBankrupt() && !game.getIsGameOver());
               // break player loop if game is over
               if (game.getIsGameOver()) {
                  break;
               }
            }
         }
         // game over
         game.gameOverProcedures(puzzle, listOfPlayers[currentPlayer], settings);
      } while (game.setPlayAnotherGame());
   }
}