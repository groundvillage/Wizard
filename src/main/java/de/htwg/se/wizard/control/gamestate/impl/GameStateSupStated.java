package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.ISubState;

/**
 * Created by Jan on 10.01.2016.
 */
public class GameStateSupStated extends GameState {

    protected ISubState supState;

    public GameStateSupStated(GameControl controller) {
        super(controller);
    }

    @Override
    public void handleUserInput(String userInput) {

    }

    @Override
    public String getState() {
        return null;
    }
}
