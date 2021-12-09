package Game;

import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    public static void main(String[] args) {
        // utils
        Scanner Scan = new Scanner(System.in); // init scanner for user inputs
        Random Rand = new Random(); // rand for comp selection, 1-3

        // vars
        int compScore = 0;
        int playerScore = 0;
        int counter = 0; // of games played

        System.out.println("It's Rock, Paper, Scissors!!!");
        System.out.println("Enter User Name:");
        String name = Scan.nextLine();
        System.out.println("Ready to Throw Hands!!!");
        while (counter == 0) {
            int compChoice = 1 + Rand.nextInt(3); // select random int 1:3

            // player input
            System.out.println(name + "'s Turn. Enter `Rock`, `Paper`, or `Scissors`");
            String playerChoice = Scan.nextLine();

            if(playerChoice.equals(compChoice)) {
                System.out.println("Tie. Next Round.");
            } else if (playerChoice.equals("Rock")) {
                System.out.println("You chose Rock."); // confirm selection
                if (compChoice.equals("Paper")) {
                    System.out.println("AI Chose Paper."); // comp selection
                    System.out.println("Computer Wins..."); // game result
                    compScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                } else {
                    System.out.println("AI Chose Scissors");
                    System.out.println(name + " Wins!");
                    playerScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                }
            } else if (playerChoice == 2) {
                System.out.println("You chose Paper."); // confirm selection
                if (compChoice == 3) {
                    System.out.println("AI Chose Scissors."); // comp selection
                    System.out.println("Computer Wins..."); // game result
                    compScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                } else {
                    System.out.println("AI Chose Rock");
                    System.out.println(name + " Wins!");
                    playerScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                }
            } else if (playerChoice == 3) {
                System.out.println("You chose Scissors."); // confirm selection
                if (compChoice == 1) {
                    System.out.println("AI Chose Rock."); // comp selection
                    System.out.println("Computer Wins..."); // game result
                    compScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                } else {
                    System.out.println("AI Chose Paper");
                    System.out.println(name + " Wins!");
                    playerScore++;
                    System.out.println("Computer: " + compScore);
                    System.out.println(name + ": " + playerScore);
                }
            } else {
// **************************************
                System.out.println("wrong choice");
            }

            // Winner Checks
            if(playerScore == 5) {
                System.out.println(name + " Won!!!");
                counter++;
            }
            if (compScore == 5) {
                System.out.println("Computer Won. Better Luck Next Time...");
                counter++;
            }
        }
    }
}
