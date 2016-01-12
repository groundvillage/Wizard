package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;


public class PlayerNameState extends UserInputSubState {

    private PreparingState gameState;
    private int currentPlayer = 0;
    private String[] nameList;

    public PlayerNameState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        this.gameState = (PreparingState) gameState;

        nameList = new String[this.gameState.getCountOfPlayer()];
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void handleUserInput(String userInput) {

        nameList[currentPlayer] = userInput;
        currentPlayer++;
        if (currentPlayer >= this.nameList.length) {
            this.gameState.setNameOfPlayers(nameList);
        } else {
            this.controller.updateObserver();
        }
    }

    @Override
    public String toString() {
        return "PREPARING_NAME";
    }

}
