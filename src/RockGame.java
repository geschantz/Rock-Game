import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RockGame {

    public static final String WELCOME_MESSAGE = "WELCOME TO ROCK PAPER SCISSORS LIZARD SPOCK.\n";
    public static final String RULES_MESSAGE = """
            Rules:
            
            Scissors cuts Paper
            
            Paper covers Rock
            
            Rock crushes Lizard
                
            Lizard poisons Spock
                
            Spock smashes Scissors
                
            Scissors decapitates Lizard
                
            Lizard eats Paper
                
            Paper disproves Spock
                
            Spock vaporizes Rock
                
            Rock crushes Scissors

            If both players choose the same option → Tie
                """;
    public static final String READY_MESSAGE = "Enter 'ready' to continue";
    public static final String ORIGINAL_PROMPT = "Rock! Paper! Scissors! Lizard! Spock! →";
    String input = null;
    Scanner scanner = new Scanner(System.in);
    Action userAction = null;

    enum Action {
        ROCK,
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK,
        UNDEFINED;

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
        WIN(" you beat "),
        LOSE(" you lost to "),
        TIE(" you tied with ");

        private final String message;

        Result(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public RockGame() {

        this.pregameMessages();
        this.readyToProceed();
        scanner.nextLine();
        this.getInputString();
        this.userAction = this.getValidAction();
    }

    public void pregameMessages(){

        System.out.println(WELCOME_MESSAGE);
        System.out.println(RULES_MESSAGE);
    }

    public void readyToProceed() {

        String readyString = null;
        boolean isReady = false;

        while (true) {
            if (!isReady) {
                System.out.println(READY_MESSAGE);
                readyString = scanner.next();
                isReady = true;
            }

            if ("ready".equals(readyString)) {
                //clear console
                isReady = true;
                break;
            } else {
                //clear console
                System.out.println(RULES_MESSAGE);
                isReady = false;
            }
        }
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
                userAction =  Action.UNDEFINED;
            }
        }
        return userAction;
    }

    public Action getComputerAction () {

        Action[] actions = Action.values();

        Random random = new Random();

        int randomActionIndex = random.nextInt(actions.length-1);

        Action randomAction = actions[randomActionIndex];

        return randomAction;
    }

    public void runGame() {
        Action computerAction = getComputerAction();
        Result result = this.userAction.compareAction(computerAction);

        System.out.println(result + result.getMessage() + computerAction);
    }
}