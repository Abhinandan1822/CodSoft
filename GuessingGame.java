import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        
        // Main loop for multiple rounds
        do {
            System.out.println("\nWelcome to the Guessing Game!");
            System.out.println("I'll pick a random number between 1 and 100.");
            System.out.println("You have 10 chances to guess it correctly. Let's see if you can do it!");

            int targetNumber = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            // While loop for user attempts
            while (attempts < 10 && !guessedCorrectly) {
                System.out.print("\nTake a guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("Hmm... that's too low. Try a bigger number.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Oops, that's too high. Try a smaller number.");
                } else {
                    System.out.println("Bingo! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;  // Increment score for a correct guess
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Ah, tough luck! The correct number was " + targetNumber + ".");
            }

            // Ask if the user wants to play again
            System.out.print("\nWould you like to play another round? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        // End of game summary
        System.out.println("\nThanks for playing! You won " + score + " round(s). Have a great day!");
        scanner.close();
    }
}
