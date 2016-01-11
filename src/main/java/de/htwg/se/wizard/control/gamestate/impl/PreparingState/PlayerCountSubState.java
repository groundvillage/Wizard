package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.gamestate.IGameState;
import de.htwg.se.wizard.control.gamestate.ISubState;
import de.htwg.se.wizard.control.gamestate.impl.SubState;

/**
 * Created by Jan on 10.01.2016.
 */
public class PlayerCountSubState extends SubState {

    private PreparingState gameState;
    private int maxCount;

    public PlayerCountSubState(IGameState gameState, int maxCount) {
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
        return "PREPARING_COUNT";
    }

}
