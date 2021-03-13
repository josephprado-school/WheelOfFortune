// Author: Joe Prado
// Date: 2/25/2021
// File: CS210 Final Project - Wheel of Fortune Game

// a class of objects that stores player data

import java.util.Scanner;

public class Player {
   private String playerName;
   private int playerBalance = 0;
   private int numGamesWon = 0;
   
   Scanner keyboard = new Scanner(System.in);
   
   public Player(String name) {
      playerName = name;
   }
   
   public void printPlayerStats() {
      System.out.println();
      System.out.println("Player: " + playerName);
      System.out.format("Balance: $%,d%n", playerBalance);
   }
   
   // setter methods
   
   public void setPlayerName(String name) {
      playerName = name;
   }
   
   public void setPlayerBalance(int prize, boolean isBankrupt) {
      if (isBankrupt) {
         playerBalance = 0;
      } else {
      playerBalance += prize;
      }
   }
   
   public void setNumGamesWon(int games) {
      numGamesWon += games;
   }
   
   // getter methods
   
   public String getPlayerName() {
      return playerName;
   }
   
   public int getPlayerBalance() {
      return playerBalance;
   }
   
   public int getNumGamesWon() {
      return numGamesWon;
   }
}
