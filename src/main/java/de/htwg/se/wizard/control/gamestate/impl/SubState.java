package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.gamestate.IGameState;
import de.htwg.se.wizard.control.gamestate.ISubState;

/**
 * Created by Jan on 10.01.2016.
 */
public class SubState implements ISubState {

    /*protected IGameState gameState;

    public SubState(IGameState gameState) {
        this.gameState = gameState;
    }*/

    @Override
    public void handle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handleUserInput(String userInput) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getState() {
        return null;
    }
}
