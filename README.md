# WheelOfFortune
CS210 Final Project
Date: 3/12/2021
================================================

Explanation:
This program is a Wheel of Fortune game, similar to the tv show of the same name.
A player will be given a random word puzzle and have multiple chances to guess the answer to
the puzzle. Each turn, the player will spin a wheel to determine a cash prize to play for that
round. Then they will be asked to guess a letter in the puzzle, or to solve the puzzle by typing
the full answer. If their guess is correct, that prize will be added to their balance. The game
will continue until either the max number of rounds have expired, or the player has solved the 
puzzle.

How to run the program:
Download all eight .java files and the ListOfPuzzles.csv, and save them in the same directory.
Compile and then run the file named WheelOfFortune.java. Throughout the game, the player will 
be promted for user input through the keyboard. Enter the appropriate inputs 
("y" for yes, "n" for no, integers, etc.).

Known bugs:
1. when making a guess, nothing prevents a player from guessing the same letter more than once, meaning that
they are able to keep guessing the same letter over and over and keep winning cash
