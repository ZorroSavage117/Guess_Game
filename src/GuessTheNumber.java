import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guess the Number Game!");

        // Difficulty levels
        System.out.println("Choose your difficulty level:");
        System.out.println("1. Easy (Double the minimum needed guesses)");
        System.out.println("2. Medium (Exactly the minimum needed guesses)");
        System.out.println("3. Hard (Half the minimum needed guesses)");
        System.out.println("4. One Guess Mode");
        System.out.print("Enter your choice: ");
        int difficulty = scanner.nextInt();

        if (difficulty != 4) {
            // Set maximum number
            System.out.print("Enter the maximum number: ");
            int maxNumber = scanner.nextInt();

            // Generate random number within the specified range
            int randomNumber = random.nextInt(maxNumber) + 1;

            // Calculate minimum guesses based on difficulty
            int minGuesses;
            switch (difficulty) {
                case 1:
                    minGuesses = (int) Math.ceil(Math.log(maxNumber) / Math.log(2)) * 2;
                    break;
                case 2:
                    minGuesses = (int) Math.ceil(Math.log(maxNumber) / Math.log(2));
                    break;
                case 3:
                    minGuesses = (int) Math.ceil(Math.log(maxNumber) / Math.log(2)) / 2;
                    break;
                default:
                    minGuesses = (int) Math.ceil(Math.log(maxNumber) / Math.log(2));
            }

            System.out.println("You have " + minGuesses + " guesses to get the number.");

            int guessCount = 0;
            boolean guessedCorrectly = false;

            // Game loop
            while (guessCount < minGuesses) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                guessCount++;

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    break;
                } else {
                    // Cryptic feedback
                    if (guess < randomNumber) {
                        System.out.println(guess + ">");
                    } else {
                        System.out.println("<" + guess);
                    }
                }
            }

            // Display result
            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the number in " + guessCount + " guesses.");
            } else {
                System.out.println("Sorry, you didn't guess the number. It was " + randomNumber + ".");
            }
        } else {
            // One guess mode
            System.out.print("Enter the maximum number: ");
            int maxNumber = scanner.nextInt();
            int randomNumber = random.nextInt(maxNumber) + 1;
            System.out.print("You have only one guess to get the number. Enter your guess: ");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in one try.");
            } else {
                System.out.println("Sorry, you didn't guess the number. It was " + randomNumber + ".");
            }
        }

        scanner.close();
    }
}
