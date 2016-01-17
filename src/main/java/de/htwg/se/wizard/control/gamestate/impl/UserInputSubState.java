package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;

/**
 * Created by Jan on 12.01.2016.
 */
public abstract class UserInputSubState extends SubState implements IUserInputState {

    public UserInputSubState(GameControl controller, IStateWithSubState mainState) {
        super(controller, mainState);
    }

    @Override
    public String getErrorMessage() {
        return "";
    }
}
