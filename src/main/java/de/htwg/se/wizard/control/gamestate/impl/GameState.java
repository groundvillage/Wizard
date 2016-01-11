package de.htwg.se.wizard.control.gamestate.impl;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IMainState;
import de.htwg.se.wizard.control.gamestate.IState;

/**
 * Created by Jan on 30.12.2015.
 */
public abstract class GameState implements IMainState {

    protected GameControl controller;

    public GameState(GameControl controller) {
        this.controller = controller;
    }

    public void handle() {
        throw new UnsupportedOperationException();
    }

}
