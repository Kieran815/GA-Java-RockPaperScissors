package Game;

public abstract class Player {
//    private String name = "";
//    private String playerChoice = "";
    private int playerScore = 0;

//    public Player() {
//        this.name = name;
//        this.playerChoice = playerChoice;
//    }

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
