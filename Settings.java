// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

// a class that configures the game's various settings

import java.util.Scanner;

public class Settings {
   private int numPlayers = 0;
   private int maxNumRounds = 25;
   private int prizeValueIncrement = 1_000;
   private boolean allowBankruptcy = true;
   private Player[] listOfPlayers;
   
   Scanner keyboard = new Scanner(System.in);
   
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
   
   // intial game setup, sets number of players, number of rounds, prize increment, and enables/disables bankruptcy
   public void gameSetup() {
      System.out.println("Let's begin.");
      setNumPlayers();
      createNewPlayers(numPlayers);
      String changeSettings;
      do {
         System.out.println();
         System.out.println("Would you like to change the game's defualt settings?");
         System.out.print("Enter 'y' for yes, 'n' for no: ");
         changeSettings = keyboard.next().substring(0,1).toLowerCase();
         switch (changeSettings) {
            case "y":
               setMaxNumRounds();
               setPrizeValueIncrement();
               setAllowBankruptcy();
               break;
            case "n":
               break;
            default:
               break;
         }
      } while (!changeSettings.equals("y") && !changeSettings.equals("n"));
   }
   
   // method that takes number of players and creates new player objects
   public void createNewPlayers(int numOfPlayers) {
      listOfPlayers = new Player[numOfPlayers];
      for (int i = 0; i < numOfPlayers; i++) {
         System.out.println();
         System.out.print("Player" + (i + 1) + " Name: ");
         String name = keyboard.next();
         listOfPlayers[i] = new Player(name);
      }
   }
   
   // method that sets number of players
   public void setNumPlayers() {
      do {
         try {
            System.out.println();
            System.out.print("How many players will be playing? \nEnter an integer from 1-4: ");
            numPlayers = keyboard.nextInt();
            continue;
         } catch (java.util.InputMismatchException e) {
            keyboard.next();
            continue;
         }
      } while (numPlayers < 1 || numPlayers > 4);
   }
   
   // method that sets maximum number of rounds
   public void setMaxNumRounds() {
      do {
         try {
            System.out.println();
            System.out.print("Maximum Number of Rounds \nEnter an integer value >= 1: ");
            maxNumRounds = keyboard.nextInt();
            continue;
         } catch (java.util.InputMismatchException e) {
            keyboard.next();
            continue;
         }
      } while (maxNumRounds < 1);
   }
   
   // method that sets prize value increment
   public void setPrizeValueIncrement() {
      do {
         try {
            System.out.println();
            System.out.print("Prize Value Increment \nEnter and integer value >= 100: ");
            prizeValueIncrement = keyboard.nextInt();
            continue;
         } catch (java.util.InputMismatchException e) {
            keyboard.next();
            continue;
         }
      } while (prizeValueIncrement < 100);
   }
   
   public void setAllowBankruptcy() {
      String bankrupt;
      do {
         System.out.println();
         System.out.print("Allow Bankruptcy? \nEnter 'y' for yes, 'n' for no: ");
         bankrupt = keyboard.next().substring(0,1).toLowerCase();
         switch (bankrupt) {
            case "y":
               allowBankruptcy = true;
               break;
            case "n":
               allowBankruptcy = false;
               break;
            default:
               break;   
         }
      } while (!bankrupt.equals("y") && !bankrupt.equals("n"));
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