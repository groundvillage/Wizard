package de.htwg.se.wizard.control.gamestate.impl;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IMainState;


public abstract class MainState implements IMainState {

    protected GameControl controller;

    public MainState(GameControl controller) {
        this.controller = controller;
    }

    public void handle() {
        throw new UnsupportedOperationException();
    }

}
