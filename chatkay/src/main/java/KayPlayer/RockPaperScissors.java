package KayPlayer;

import java.util.Random;
import java.util.Scanner;

import kay.App;

/**
 * RockPaperScissors
 */
public class RockPaperScissors {

    private int playerScore;
    private int cpuScore;
    private final String[] options = {"Rock", "Paper", "Scissors"};
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void start() {
        System.out.println("Welcome to Rock-Paper-Scissors game! First to win 3 rounds wins the game.");

        while (true) {
            System.out.println("Enter your choice (Rock/Paper/Scissors) or 'exit' to quit:");

            String userChoice = scanner.nextLine();
            if ("exit".equalsIgnoreCase(userChoice)) {
                break;
            }

            int cpuChoiceIndex = random.nextInt(options.length);
            String cpuChoice = options[cpuChoiceIndex];

            System.out.println("KayPlayer chose: " + cpuChoice);

            if (userChoice.equalsIgnoreCase(cpuChoice)) {
                System.out.println("It's a tie!");
            } else if (("Rock".equalsIgnoreCase(userChoice) && "Scissors".equalsIgnoreCase(cpuChoice)) ||
                    ("Scissors".equalsIgnoreCase(userChoice) && "Paper".equalsIgnoreCase(cpuChoice)) ||
                    ("Paper".equalsIgnoreCase(userChoice) && "Rock".equalsIgnoreCase(cpuChoice))) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (("Rock".equalsIgnoreCase(cpuChoice) && "Scissors".equalsIgnoreCase(userChoice)) ||
                    ("Scissors".equalsIgnoreCase(cpuChoice) && "Paper".equalsIgnoreCase(userChoice)) ||
                    ("Paper".equalsIgnoreCase(cpuChoice) && "Rock".equalsIgnoreCase(userChoice))) {
                System.out.println("KayPlayer wins this round!");
                cpuScore++;
            } else {
                System.out.println("Invalid input. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            System.out.println("Score - Player: " + playerScore + ", KayPlayer: " + cpuScore);

            if (playerScore == 3) {
                System.out.println("Congratulations! You've won the game.");
                break;
            } else if (cpuScore == 3) {
                System.out.println("KayPlayer has won the game. Better luck next time!");
                break;
            }
        }

        System.out.println("Thanks for playing! Goodbye.");
        App.setChoix(0);
        App.main(null);
    }
}