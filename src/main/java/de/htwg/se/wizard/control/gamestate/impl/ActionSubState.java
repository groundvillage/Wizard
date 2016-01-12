package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;

/**
 * Created by Jan on 12.01.2016.
 */
public abstract class ActionSubState extends SubState  implements IActionState {

    public ActionSubState(GameControl controller, IStateWithSubState mainState) {
        super(controller, mainState);
    }
}
