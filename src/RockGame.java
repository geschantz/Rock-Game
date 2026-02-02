import java.util.Scanner;
import java.util.Random;

public class RockGame {

    public static final String WELCOME_MESSAGE = "WELCOME TO ROCK PAPER SCISSORS LIZARD SPOCK.";
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
    public static final String READY_MESSAGE = "Press any key to continue...";
    public String input;
    boolean validInput = true;

    enum Action {

        ROCK,
        PAPER,
        SCISSORS,
        LIZARD,
        SPOCK,
        UNDEFINED,
    };

    public RockGame() {

        Scanner scanner = new Scanner(System.in);
        this.pregameMessages();
        this.isReady();
        this.getValidAction("rock");
    }

    public void pregameMessages(){

        System.out.println(WELCOME_MESSAGE);
        System.out.println(RULES_MESSAGE);
    }

    public boolean isReady() {

        System.out.println(READY_MESSAGE);
        return false;
    }

    public Action getValidAction(String input) {

        input = input.toUpperCase();
        boolean validInput = true;
        Action userAction = null;

        while (true) {

            if (!validInput) {
                System.out.printf("'%s' is not acceptable input", input);
                validInput = true;
            }
            try {
                userAction =  Action.valueOf(input);
                break;
            } catch (IllegalArgumentException e) {
                userAction =  Action.UNDEFINED;
            }
        }
        return userAction;
    }

    public static char optionRandomizer() {
        String options = "rpslk";

        Random random = new Random();

        int randomIndex = random.nextInt(options.length());

        return options.charAt(randomIndex);
    }

}