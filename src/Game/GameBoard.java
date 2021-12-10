package Game;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    // utils
    static Scanner Scan = new Scanner(System.in); // init scanner for user inputs
    static Random Rand = new Random(); // rand for comp selection, 1-3

    static String[] choices = {"rock", "paper", "scissors"};

    static Player player1 = new HumanPlayer();
    static Player player2;
    static Player currentPlayer = player1;
    static boolean gameOn = true;
    static int counter = 1; // of games played

    public static void main(String[] args) {

        // ********** GAME SETUP  **********
        System.out.println("It's Rock, Paper, Scissors!!!");
        System.out.println("Main Menu");
        System.out.println("=========");
        System.out.println("Enter Player One's Name:");
        player1.setName(Scan.nextLine());
        // Player Creation
        setPlayers();




        System.out.println("Ready to Throw Hands!!!");
        System.out.println("=======================");


        // ********** GAME LOGIC  **********
        while (gameOn == true) {
            playerMove(currentPlayer); // player 1 move
            togglePlayer();
            playerMove(currentPlayer); // player 2 move

            if(player1.getPlayerChoice().equals(player2.getPlayerChoice())) {
                System.out.println("Tie. Next Round.");
            } else if (player1.getPlayerChoice().equals(choices[0])) { // ROCK
                System.out.println(player1.getName() + " chose " + player1.getPlayerChoice() + "."); // confirm selection
                if (player2.getPlayerChoice().equals(choices[1])) {
                    System.out.println(player2.getName() + " Chose " + choices[1] + "."); // comp selection
                    System.out.println(player2.getName() + " Wins!"); // game result
                    player2.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                } else if (player2.getPlayerChoice().equals(choices[2])) {
                    System.out.println(player2.getName() + " Chose " + player2.getPlayerChoice() + ".");
                    System.out.println(player1.getName() + " Wins!");
                    player1.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                }
            } else if (player1.getPlayerChoice().equals(choices[1])) { // PAPER
                System.out.println(player1.getName() + " chose " + player1.getPlayerChoice() + "."); // confirm selection
                if (player2.getPlayerChoice().equals(choices[2])) {
                    System.out.println(player2.getName() + " Chose " + player2.getPlayerChoice() + "."); // comp selection
                    System.out.println(player2.getName() + " Wins!"); // game result
                    player2.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                } else if (player2.getPlayerChoice().equals(choices[0])) {
                    System.out.println(player2.getName() + " Chose Rock");
                    System.out.println(player1.getName() + " Wins!");
                    player1.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                }
            } else if (player1.getPlayerChoice().equals(choices[2])) { // SCISSORS
                System.out.println(player1.getName() + " chose " + player1.getPlayerChoice() + "."); // confirm selection
                if (player2.getPlayerChoice().equals(choices[0])) {
                    System.out.println(player2.getName() + " Chose " + player2.getPlayerChoice() + "."); // comp selection
                    System.out.println(player2.getName() + " Wins!"); // game result
                    player2.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                } else if (player2.getPlayerChoice().equals(choices[1])) {
                    System.out.println(player2.getName() + " Chose " + player2.getPlayerChoice() + ".");
                    System.out.println(player1.getName() + " Wins!");
                    player1.setPlayerScore();
                    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
                    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
                } else {
                    System.out.println("Invalid Selection. Try again, " + player2.getName());
                    currentPlayer.setPlayerChoice(Scan.nextLine().toLowerCase());

                }
            }

            // Winner Checks
            if(player1.getPlayerScore() == 5) {
                gameOn = false;
                System.out.println(player1.getName() + " Won. Better Luck Next Time, " + player2.getName() + "!");
                restart();
            } else if (player2.getPlayerScore() == 5) {
                gameOn = false;
                System.out.println(player2.getName() + " Won. Better Luck Next Time, " + player1.getName() + "!");
                restart();
            } else {
                System.out.println("Next Round - THROW:");
                System.out.println("===================");
            }

            togglePlayer(); // toggle back to player1
        }
    }

    static void setPlayers() {
        System.out.println("Enter Number of Players: `1` or `2`:");
        int numPlayers = Scan.nextInt();
        Scan.nextLine();
        if (numPlayers == 1) {
            player2 = new ComputerPlayer();
            player2.setName("");
        } else if (numPlayers == 2) {
            player2 = new HumanPlayer();
            System.out.println("Enter Player Two's Name:");
            player2.setName(Scan.nextLine());
        } else {
            System.out.println("Invalid Entry.");
            setPlayers();
        }
    }

    static void togglePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    static void playerMove(Player nextPlayer) {
        String playerSelection;
        if (currentPlayer == player2 && player2 instanceof ComputerPlayer) {
            player2.setPlayerChoice("");
        } else {
            System.out.println(nextPlayer.getName() + "'s Turn. Enter `Rock`, `Paper`, or `Scissors`"); // player input
            playerSelection = Scan.nextLine().toLowerCase(); // computer scans
            checkPlayerChoice(playerSelection); // check player input
        }

    }

    static void checkPlayerChoice(String playerSelection) {
        if (Arrays.stream(choices).anyMatch(choice -> choice.equals(playerSelection))) {
            currentPlayer.setPlayerChoice(playerSelection.toLowerCase());
        } else {
            System.out.println("Invalid Entry. Try Again");
            playerMove(currentPlayer);
        }
    }

    static void restart() {
        System.out.println("Play Again? `Yes` or `No`.");
        String newGame = Scan.nextLine();

        if (newGame.equalsIgnoreCase("yes")) {
            counter += 1;
            gameOn = true;
            System.out.println("Game" + counter);
            player1.resetPlayerScore();
            player2.resetPlayerScore();
        } else if (newGame.equalsIgnoreCase("no")) {
            System.out.println("Thanks for Playing");
        } else {
            System.out.println("Invalid Entry. Please Try Again.");
            restart();
        }

    }
}
