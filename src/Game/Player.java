package Game;

public abstract class Player {
  private int playerScore = 0;

  public void setPlayerScore() {
    playerScore++;
  }

  public void resetPlayerScore() {
    playerScore = 0;
  }

  public int getPlayerScore() {
    return playerScore;
  }

  abstract void setName(String pName);
  abstract void setPlayerChoice(String pChoice);
  abstract String getName();
  abstract String getPlayerChoice();
}
