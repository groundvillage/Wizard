package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IState;


public abstract class State implements IState{

    protected GameControl controller;

    public State(GameControl controller) {
         this.controller = controller;
    }

    @Override
    public IState getState() {
        return this;
    }
}
