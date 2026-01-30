import java.util.Random;
import java.util.Scanner;

public class RockGame {

    public RockGame() {
        Scanner scanner = new Scanner(System.in);
        pregameMessages();
        isReady();
    }

    public void pregameMessages(){

        String welcomeMessage = "WELCOME TO ROCK PAPER SCISSORS LIZARD SPOCK.";
        String rulesMessage = """
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

        System.out.println(welcomeMessage);
        System.out.println(rulesMessage);
    }

    public boolean isReady() {
        String readyMessage = "Enter 'ready' when you want to play.";
        System.out.println(readyMessage);
        return false;
    }

    public String getValidString(String input) {
        return "";
    }

    public static char optionRandomizer() {
        String options = "rpslk";

        Random random = new Random();

        int randomIndex = random.nextInt(options.length());

        return options.charAt(randomIndex);
    }

}