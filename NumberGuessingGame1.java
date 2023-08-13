import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing the Number Guessing Game. Goodbye!");
    }

    private static void playGame(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;

        System.out.println("\nI'm thinking of a number between 1 and 100. Try to guess it!");

        while (true) {
            System.out.print("Take a guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input from the scanner
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            }
        }
    }
}
