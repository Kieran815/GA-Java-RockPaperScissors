package Game;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
  static Scanner Scan = new Scanner(System.in);
  static String[] choices = {"rock", "paper", "scissors"};
  static Player player1 = new HumanPlayer();
  static String p1Choice;
  static Player player2;
  static String p2Choice;
  static Player currentPlayer = player1;
  static boolean gameOn = true;
  static int counter = 1;

  public static void main(String[] args) {
    System.out.println("It's Rock, Paper, Scissors!!!");
    System.out.println("Main Menu");
    System.out.println("=========\n");
    System.out.println("Enter Player One's Name:");
    player1.setName(Scan.nextLine());
    setPlayers();
    System.out.println("Ready to Throw Hands!!!");
    System.out.println("=======================\n");
    while (gameOn) {
      playerMove(currentPlayer);
      togglePlayer();
      playerMove(currentPlayer);
      togglePlayer();
      scorePoints();
      checkWin();
    }
  }

  static void setPlayers() {
    System.out.println("Enter Number of Players: `1` or `2`:");
    String numPlayers = Scan.nextLine();
    if (numPlayers.equals("1")) {
      player2 = new ComputerPlayer();
      player2.setName("");
    } else if (numPlayers.equals("2")) {
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
      p2Choice = player2.getName() + " Chose " + player2.getPlayerChoice() + ".";
    } else {
      System.out.println(nextPlayer.getName() + "'s Turn. Enter `Rock`, `Paper`, or `Scissors`");
      playerSelection = Scan.nextLine().toLowerCase();
      checkPlayerChoice(playerSelection);
    }
  }

  static void scorePoints() {
    if(player1.getPlayerChoice().equals(player2.getPlayerChoice())) {
      System.out.println("Tie. Next Round.");
    } else if (player1.getPlayerChoice().equals(choices[0])) {
      throwRock();
    } else if (player1.getPlayerChoice().equals(choices[1])) {
      throwPaper();
    } else {
      throwScissors();
    }
  }

  static void getScores() {
    System.out.println(player1.getName() + ": " + player1.getPlayerScore());
    System.out.println(player2.getName() + ": " + player2.getPlayerScore());
  }

  static void checkPlayerChoice(String playerSelection) {
    if (Arrays.stream(choices).anyMatch(choice -> choice.equals(playerSelection))) {
      currentPlayer.setPlayerChoice(playerSelection.toLowerCase());
      p1Choice = player1.getName() + " Chose " + player1.getPlayerChoice() + ".";
      p2Choice = player2.getName() + " Chose " + player2.getPlayerChoice() + ".";
    } else {
      System.out.println("Invalid Entry. Try Again");
      playerMove(currentPlayer);
    }
  }

  static void throwRock() {
    System.out.println(p1Choice);
    if (player2.getPlayerChoice().equals(choices[1])) {
      p2Wins();
    } else {
      p1Wins();
    }
  }

  static void throwPaper() {
    System.out.println(p1Choice);
    if (player2.getPlayerChoice().equals(choices[2])) {
      p2Wins();
    } else {
      p1Wins();
    }
  }

  static void throwScissors() {
    System.out.println(p1Choice);
    if (player2.getPlayerChoice().equals(choices[0])) {
      p2Wins();
    } else {
      p1Wins();
    }
  }

  static void checkWin() {
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
      System.out.println("===================\n");
    }
  }

  static void p1Wins() {
    System.out.println(p2Choice);
    System.out.println(player1.getName() + " Wins!");
    player1.setPlayerScore();
    getScores();
  }

  static void p2Wins() {
    System.out.println(p2Choice);
    System.out.println(player2.getName() + " Wins!");
    player2.setPlayerScore();
    getScores();
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
