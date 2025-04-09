
    import java.util.Random;
import java.util.Scanner;

    public class task1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            boolean playAgain;
            do {
                int numberToGuess = random.nextInt(100) + 1;
                int userGuess = 0;
                int attempts = 0;
                int maxAttempts = 10;
                boolean guessedCorrectly = false;

                System.out.println("Welcome to the Number Game!");
                System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

                while (attempts < maxAttempts && !guessedCorrectly) {
                    System.out.print("Enter your guess: ");
                    userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else if (userGuess > numberToGuess) {
                        System.out.println("Too high! Try again.");
                    } else {
                        guessedCorrectly = true;
                        System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
                }

                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.next();
                playAgain = response.equalsIgnoreCase("yes");

            } while (playAgain);

            System.out.println("Thank you for playing!");
            scanner.close();
        }
    }

