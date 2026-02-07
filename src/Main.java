import java.util.Scanner;

public class Main {

    static int numOfWins = 0;
    static int numOfLosses = 0;
    static int numOfTies = 0;
    static int numOfRounds = 0;
    static String input = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean playAgain = true;

        RockGame game = new RockGame();

        // Overall while loop which runs the program
        while (playAgain) {
            updateScore(game.runGame());

            input = promptUserForInput("\nWould you like to play again? (Y/N)");

            // Checks if the user wants to play again
            if (input.equals("Y")) {
                playAgain = true;
            } else if (input.equals("N")) {
                printFinalScore();
                playAgain = false;
            } else {
                while (!input.equals("Y") && !input.equals("N")) {
                    input = promptUserForInput("Enter Y/N");
                }
                if (input.equals("Y")) {
                    playAgain = true;
                } else {
                    printFinalScore();
                    playAgain = false;
                }

            }
        }
    }

    //Updates the score of the user based on whether the user wins, loses, or ties with the computer
    private static void updateScore(RockGame.Result result) {
        if (result == RockGame.Result.WIN) {
            numOfWins += 1;
            numOfRounds += 1;
        } else if (result == RockGame.Result.LOSE) {
            numOfLosses += 1;
            numOfRounds += 1;
        } else if (result == RockGame.Result.TIE) {
            numOfTies += 1;
        }

        System.out.printf("\nRounds: %s Wins: %s, Losses: %s, Ties: %s\n", numOfRounds, numOfWins, numOfLosses, numOfTies);
    }

    //Print a prompt and gets input from the user
    private static String promptUserForInput(String prompt) {
        String input;
        System.out.println(prompt);
        input = scanner.nextLine();
        input = input.toUpperCase();
        return input;
    }

    //Prints the final score
    private static void printFinalScore() {
        if (numOfWins > numOfLosses) {
            System.out.printf("\nYou won overall! You beat the computer %s times out of %s.\n", numOfWins, numOfRounds);
        } else if (numOfLosses > numOfWins) {
            System.out.printf("\nYou lost overall. The computer beat you  %s times out of %s.\n", numOfLosses, numOfRounds);
        } else {
            System.out.printf("\nYou tied overall. The score was  %s-%s.\n", numOfWins, numOfLosses);
        }
    }
}