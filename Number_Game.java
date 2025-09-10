import java.util.Scanner;
import java.util.Random;

public class Number_Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_TRIES = 7;

        int totalWins = 0;
        int gameNumber = 1;
        char choice;

        do {
            int target = random.nextInt(MAX - MIN + 1) + MIN;
            int tries = 0;
            boolean isGuessed = false;

            System.out.println("\n=== Game " + gameNumber + " ===");
            System.out.println("Guess the number between " + MIN + " and " + MAX + ".");

            while (tries < MAX_TRIES) {
                System.out.print("Try " + (tries + 1) + ": ");
                int userGuess;

                // Check if input is a number
                if (input.hasNextInt()) {
                    userGuess = input.nextInt();
                    tries++;

                    if (userGuess == target) {
                        System.out.println("Nice! You got it in " + tries + " try/tries.");
                        totalWins++;
                        isGuessed = true;
                        break;
                    } else if (userGuess > target) {
                        System.out.println("Too high!");
                    } else {
                        System.out.println("Too low!");
                    }
                } else {
                    // Invalid input handling
                    System.out.println("Enter a valid number!");
                    input.next(); // clear invalid input
                }
            }

            if (!isGuessed) {
                System.out.println("Oops! You couldn't guess it. The number was: " + target);
            }

            System.out.print("Wanna play again? (Y/N): ");
            choice = input.next().charAt(0);

            gameNumber++;

        } while (choice == 'Y' || choice == 'y');

        System.out.println("\nYou won " + totalWins + " time(s). Thanks for playing!");
        input.close();
    }
}
