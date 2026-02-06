import java.util.Scanner;

public class Main  {

    public static void main(String[]  args) {

        int numOfWins = 0;
        int numOfLosses = 0;
        int numOfTies = 0;
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        String input = null;

        RockGame game = new RockGame();

        while (playAgain) {
            game.runGame();
            if (RockGame.result  == RockGame.Result.WIN) {
                numOfWins += 1;

            } else if (RockGame.result == RockGame.Result.LOSE) {
                numOfLosses += 1;

            } else if (RockGame.result == RockGame.Result.TIE) {
                numOfTies += 1;
            }

            System.out.printf("\nW: %s, L: %s, T: %s\n", numOfWins, numOfLosses, numOfTies);

            System.out.println("\nWould you like to play again? (Y/N)");
            input = scanner.nextLine();

            if  (input.equals("Y")) {
                playAgain = true;

            } else if (input.equals("N")) {
                playAgain = false;
                break;

            } else {
                System.out.println("(Y/N)");
            }
        }
    }
}