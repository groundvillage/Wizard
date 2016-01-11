package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.IMainState;

/**
 * Created by Jan on 10.01.2016.
 */
public class PlayerCountSubState implements IState{

    private PreparingState gameState;
    private int maxCount;

    public PlayerCountSubState(IMainState gameState, int maxCount) {
        this.gameState = (PreparingState) gameState;
        this.maxCount = maxCount;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    @Override
    public void handleUserInput(String userInput) {
        this.gameState.setNumberOfPlayers(Integer.parseInt(userInput));

        this.gameState.setSubState(new PlayerNameSubState(this.gameState));

    }

    @Override
    public String toString() {
        return "PREPARING-PLAYERCOUNT";
    }

    @Override
    public String getState() {
        return null;
    }
}
