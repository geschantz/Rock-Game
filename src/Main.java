public class Main  {

    public static void main(String[]  args) {
        int numOfWins = 0;
        int numOfLosses = 0;
        int numOfTies = 0;

        RockGame game = new RockGame();

        for (int i = 1; i <= 5; i++) {
            game.runGame();
            if (RockGame.result  == RockGame.Result.WIN) {
                numOfWins += 1;
            } else if (RockGame.result == RockGame.Result.LOSE) {
                numOfLosses += 1;
            } else if (RockGame.result == RockGame.Result.TIE) {
                numOfTies += 1;
            }

            System.out.printf("\nW: %s, L: %s, T: %s\n", numOfWins, numOfLosses, numOfTies);
        }
    }
}