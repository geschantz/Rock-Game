import java.util.Scanner;

public class Main  {

    public static void main(String[]  args) {

        int numOfWins = 0;
        int numOfLosses = 0;
        int numOfTies = 0;
        int numOfRounds = 0;
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        String input = null;

        RockGame game = new RockGame();

        while (playAgain) {
            game.runGame();
            if (RockGame.result  == RockGame.Result.WIN) {
                numOfWins += 1;
                numOfRounds += 1;

            } else if (RockGame.result == RockGame.Result.LOSE) {
                numOfLosses += 1;
                numOfRounds += 1;

            } else if (RockGame.result == RockGame.Result.TIE) {
                numOfTies += 1;
            }

            System.out.printf("\nWins: %s, Losses: %s, Ties: %s\n", numOfWins, numOfLosses, numOfTies);

            System.out.println("\nWould you like to play again? (Y/N)");
            input = scanner.nextLine();
            input = input.toUpperCase();

            if  (input.equals("Y")) {
                playAgain = true;

            } else if (input.equals("N")) {
                if (numOfWins > numOfLosses) {
                    System.out.printf("\nYou won overall! You beat the computer %s times out of %s.\n",  numOfWins, numOfRounds);

                } else if (numOfLosses > numOfWins) {
                    System.out.printf("\nYou lost overall. The computer beat you  %s times out of %s.\n",  numOfLosses, numOfRounds);

                } else {
                    System.out.printf("\nYou tied overall. The score was  %s-%s.\n",  numOfWins, numOfLosses);

                }
                playAgain = false;

            } else {
                while (!input.equals("Y") && !input.equals("N")) {
                    System.out.println("Enter Y/N");
                    input = scanner.nextLine();
                    input = input.toUpperCase();
                }
            }
        }
    }
}