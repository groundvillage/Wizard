package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;


public abstract class UserInputSubState extends SubState implements IUserInputState {

    public UserInputSubState(GameControl controller, IStateWithSubState mainState) {
        super(controller, mainState);
    }

}
