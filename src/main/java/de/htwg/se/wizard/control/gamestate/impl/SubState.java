package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.ISubState;


public abstract class SubState  extends State implements ISubState{

    protected IStateWithSubState mainState;

    public SubState(GameControl controller, IStateWithSubState mainState) {
        super(controller);

        this.mainState = mainState;
    }
}
