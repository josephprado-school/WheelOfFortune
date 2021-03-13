import java.util.Random;

// a class that spins the wheel and retrieves the resulting prize value
public class Wheel {
   private int currentWheelPosition = 0;
   private int numPositionsOnWheel = 12;
   private int prizeValue = 0;
   private boolean isBankrupt = false;
   
   Random random = new Random();
   int[] wheelPrizes = new int[numPositionsOnWheel];
   
   // method that populates the wheel (an array of ints) with prize values of increments specified in the settings class
   // if bankruptcy is disabled (in settings), postion 0 becomes the max prize value
   public void createWheelPrizes(Settings settings) {
      for (int i = 0, j = 0; i < numPositionsOnWheel; i++) {
         if (i == 0 && !settings.getAllowBankruptcy()) {
            j = numPositionsOnWheel;
         } else {
            j = 0;
         }
         wheelPrizes[i] = (i + j) * settings.getPrizeValueIncrement();
      }
   }
   
   // when player spins, the wheel moves n postions, n = the player's chosen int + a random int between 0 and 6
   public void spinTheWheel() {
      isBankrupt = false;
      int wheelSpin = 0;
      
      // promt user for wheel spin power and generate a random int to add to player's specified wheel spin power
      String prompt = "How hard would you like to spin the wheel? \nEnter and integer value > 0";
      wheelSpin = Keyboard.getInteger(prompt, 1) + random.nextInt(6);
      System.out.println("Wheel Spin Distance: " + wheelSpin);
      
      // rotate the wheel 1 position and print value; if at max postion, reset to position 0
      for (int i = 0; i <= wheelSpin; i++) {
         if (currentWheelPosition < numPositionsOnWheel - 1) {
            currentWheelPosition++;
         } else {
            currentWheelPosition = 0;
         }
         System.out.println();
         if (wheelPrizes[currentWheelPosition] == 0) {
            System.out.print("Bankrupt");
         } else {
            System.out.format("%,8d", wheelPrizes[currentWheelPosition]);
         }
      }
      
      // set final position value as prize value
      prizeValue = wheelPrizes[currentWheelPosition];
      if (prizeValue == 0) {
         isBankrupt = true;
         System.out.println(" <<< Oh no, you're bankrupt!");
      } else {
         System.out.format(" <<< You landed on $%,d%n", prizeValue);
      }
   }
   
   public int getPrizeValue() {
      return prizeValue;
   }
   
   public boolean getIsBankrupt() {
      return isBankrupt;
   }
}