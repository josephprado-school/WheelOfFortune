// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

/*
   Pseudocode:
   1. Declare objects to be used in program
   2. Print game rules to the screen
   3. Invoke method to configure game setup
   4. Invoke method to create the wheel
   5. Set current player to first index postion
   6. Main program loop:
      Runs through multiple games, continues until player chooses to end the program
      
      7. Invoke method to generate a random puzzle
      
      8. Game loop:
         Continues until the game is over. Game ends when one of the following occurs:
            a. Puzzle is solved
            b. Maximum number of rounds has expired
         
         9. Player loop:
            Loops through each player until game is over

            10. Round loop:
               Advances game forward one round. At end of each round, player will earn a new round to play,
               unless one of the following occurs:
               a. player makes a wrong guess
               b. player goes bankrupt
               c. game is over

               11. Invoke method that plays through the round (spin wheel, check guess, etc.)

            12. Check if game is over. If so, break player loop.
               Otherwise, iterate to next player and reutrn to step 10

      13. Invoke method to close out the game (print results to screen and save to file)

      14. Ask player if they would like to play another game.
         If yes, return to step 7. Otherwise, end program.   
*/

import java.io.*;

public class WheelOfFortune {
   public static void main(String[] args) throws IOException {
      
      // object declaration
      Settings settings = new Settings();
      Wheel wheel = new Wheel();
      Puzzle puzzle = new Puzzle();
      Game game = new Game();
      
      // print game rules, configure settings, and setup the wheel
      settings.printGameRules();
      settings.gameSetup();
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
            for (currentPlayer = 0; currentPlayer < settings.getListOfPlayers().length; currentPlayer++) {

               // round loop
               // after each round, player will earn another round to play unless one of the following occurs:
               // a) player makes a wrong guess, b) player goes bankrupt, or c) game is over
               do {
                  game.playRound(puzzle, settings.getListOfPlayers()[currentPlayer], settings, wheel);
               } while (puzzle.getIsGuessCorrect() && !wheel.getIsBankrupt() && !game.getIsGameOver());

               // break player loop if game is over
               if (game.getIsGameOver()) {
                  break;
               }
            }
         }
         // game over
         game.gameOverProcedures(puzzle, settings.getListOfPlayers()[currentPlayer], settings);
      } while (game.setPlayAnotherGame());
   }
}