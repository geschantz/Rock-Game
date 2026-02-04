import java.util.Scanner;
import java.util.Random;

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

    enum Action {

        ROCK(),
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK,
        UNDEFINED,
    };

    public RockGame() {

        this.pregameMessages();
        this.readyToProceed();
        scanner.nextLine();
        this.getInputString();
        this.getValidAction();
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

        int randomActionIndex = random.nextInt(actions.length);

        Action randomAction = actions[randomActionIndex];

        return randomAction;
    }
}