package Game;

import static Game.GameBoard.Rand;
import static Game.GameBoard.choices;

class ComputerPlayer extends Player {

    private String name;
    private String playerChoice;
    private String compChoice = choices[Rand.nextInt(3)]; // select random from choices

    @Override
    void setName(String pName) { // pass empty string in method
        name = "AI";
    }

    @Override
    void setPlayerChoice(String pChoice) { // pass empty string in method
        playerChoice = compChoice;
    }

    @Override
    String getName() {
        return name;
    }

    @Override
    String getPlayerChoice() {
        return playerChoice;
    }
}
