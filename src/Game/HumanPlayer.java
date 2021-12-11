package Game;

class HumanPlayer extends Player {
  private String name;
  private String playerChoice;

  void setName(String pName) {
    name = pName;
  }

  void setPlayerChoice(String pChoice) {
    playerChoice = pChoice;
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
