File	: README.txt
Author	: Joe Prado
Project	: CS210 Final Project - Wheel of Fortune
Date	: 3/8/2021
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
Download all six .java files and the ListOfPuzzles.csv, and save them in the same directory.
Compile and then run the file named WheelOfFortune.java. Throught the game, the player will 
be promted for user input through the keyboard. Enter the appropriate inputs 
("y" for yes, "n" for no, integers, etc.).

Known bugs:
1. At the start of the program, after designating how many players will be playing,
the program will ask the user to name the players. If the user inputs a space in any of the names,
the name of the current player will be the text before the space, and the name of the next player
will be the text after the space (e.g., if you try to name player 1 "John Smith", player 1 will be
"John" and player 2 will be "Smith").

2. Though the game asks how many players will be playing, the program is still effectively a single
player game only. Multiplayer features will be added soon.