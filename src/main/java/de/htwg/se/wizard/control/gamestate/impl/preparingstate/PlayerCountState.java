package de.htwg.se.wizard.control.gamestate.impl.preparingstate;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;


public class PlayerCountState extends UserInputSubState {

    private PreparingState gameState;
    private int maxCount;

    private int minCount;

    public PlayerCountState(GameControl controller, StateWithSubState gameState, int minCount, int maxCount) {
        super(controller, gameState);
        this.gameState = (PreparingState) gameState;
        this.maxCount = maxCount;
        this.minCount = minCount;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    @Override
    public void handleUserInput(String userInput) {
        this.controller.setNumberOfPlayers(Integer.parseInt(userInput));

        this.gameState.setSubState(new PlayerNameState(this.controller, this.gameState));

    }

    @Override
    public String toString() {
        return "PREPARING_COUNT";
    }

}
