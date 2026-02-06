import javax.management.openmbean.TabularData;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RockGame {

    public static final String WELCOME_MESSAGE = "\nWELCOME TO ROCK PAPER SCISSORS LIZARD SPOCK.";
    public static final String RULES_MESSAGE = """
            
            Rules:
            - Scissors cuts Paper and decapitates Lizard
            - Paper covers Rock and disproves Spock
            - Rock crushes Scissors and crushes Lizard
            - Lizard eats Paper and poisons Spock
            - Spock smashes Scissors and Spock vaporizes Rock   
            - If both players choose the same option → Tie
                """;
    public static final String READY_MESSAGE = "Press enter to continue";
    public static final String ORIGINAL_PROMPT = "\nType one of the following: rock, paper, scissors, lizard or spock";
    String input = null;
    Scanner scanner = new Scanner(System.in);
    Action userAction = null;
    static Result result = null;

    enum Action {
        ROCK,
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK;

        public Result compareAction(Action computerAction) {

            Map<Action, Set<Action>> gameRules = createWinningMap();

            if (gameRules.get(this).contains(computerAction)) {
                return Result.WIN;
            } else if (this == computerAction) {
                return Result.TIE;
            } else {
                return Result.LOSE;
            }
        }
    }

    public static Map<Action, Set<Action>> createWinningMap() {
        Map<Action, Set<Action>> winningMap = new HashMap<>();

        winningMap.put(Action.ROCK, new HashSet<>(Arrays.asList(Action.SCISSORS, Action.LIZARD)));
        winningMap.put(Action.PAPER, new HashSet<>(Arrays.asList(Action.ROCK, Action.SPOCK)));
        winningMap.put(Action.SCISSORS, new HashSet<>(Arrays.asList(Action.PAPER, Action.LIZARD)));
        winningMap.put(Action.LIZARD, new HashSet<>(Arrays.asList(Action.PAPER, Action.SPOCK)));
        winningMap.put(Action.SPOCK, new HashSet<>(Arrays.asList(Action.ROCK, Action.SCISSORS)));

        return winningMap;
    }

    public enum Result {
        WIN("\nYou beat the computer's "),
        LOSE("\nYou lost to the computer's "),
        TIE("\nYou tied with the computer's ");

        private final String message;

        Result(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public RockGame() {
    }

    public void pregameMessages(){

        System.out.println(WELCOME_MESSAGE);
        System.out.println(RULES_MESSAGE);
    }

    public void readyToProceed() {

        System.out.println(READY_MESSAGE);
        String readyString = scanner.nextLine();
    }

    public String getInputString() {

        System.out.println(ORIGINAL_PROMPT);
        input = scanner.nextLine();
        return input;
    }

    public Action getValidAction() {

        boolean validInput = true;
        Action userAction = null;

        while (true) {

            if (!validInput) {
                System.out.printf("'%s' is not an acceptable action\n", input);
                getInputString();
                validInput = true;
            }
            try {
                String inputUpperCase = input.toUpperCase();
                userAction =  Action.valueOf(inputUpperCase);
                break;
            } catch (IllegalArgumentException e) {
                validInput = false;
            }
        }
        return userAction;
    }

    public Action getComputerAction () {

        Action[] actions = Action.values();
        Random random = new Random();
        int randomActionIndex = random.nextInt(actions.length);
        Action randomAction = actions[randomActionIndex];
        return randomAction;
    }

    public void runGame() {

        this.pregameMessages();
        this.readyToProceed();
        this.getInputString();
        this.userAction = this.getValidAction();
        Action computerAction = getComputerAction();
        result = this.userAction.compareAction(computerAction);

        System.out.println(result.getMessage() + computerAction);
    }
}