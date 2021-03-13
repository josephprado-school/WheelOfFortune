import java.util.Scanner;

// a class for reading/validating user input from the keyboard
public class Keyboard {
    private static Scanner scanner = new Scanner(System.in);
    
    // a method that reads the player's input and returns string
    public static String getString(String prompt) {
        System.out.println();
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
    
    // method that converts yes/no to true/false
    public static boolean getYesOrNo(String prompt) {
        String input;
        boolean output = false;
        do {
            System.out.println();
            System.out.print(prompt + ": ");
            input = scanner.next().substring(0,1).toLowerCase();
            scanner.nextLine();
            switch (input) {
                case "y":
                    output = true;
                    break;
                case "n":
                    output = false;
                    break;
                default:
                    break;
            }
        } while (!input.equals("y") && !input.equals("n"));
        return output;
    }

    // method that validates integer input for min/max values
    public static int getInteger(String prompt, int min, int max) {
        double output = 0.0;
        do {
            try {
                System.out.println();
                System.out.print(prompt + ": ");
                output = scanner.nextDouble();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                scanner.next();
                continue;
            }
        } while (output < min || output > max);
        return (int)output;
    }

    // method that validates integer input for min values
    public static int getInteger(String prompt, int min) {
        double output = 0;
        do {
            try {
                System.out.println();
                System.out.print(prompt + ": ");
                output = scanner.nextDouble();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                scanner.next();
                continue;
            }
        } while (output < min);
        return (int)output;
    }
}
