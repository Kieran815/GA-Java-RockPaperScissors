package Game;

import java.util.Random;
import static Game.GameBoard.choices;

class ComputerPlayer extends Player {
    private String name;
    private String playerChoice;

    @Override
    void setName(String pName) { // pass empty string in method
        name = "AI";
    }

    @Override
    void setPlayerChoice(String pChoice) {
        int random = new Random().nextInt(choices.length);
        playerChoice = choices[random];
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
