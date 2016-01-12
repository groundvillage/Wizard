package de.htwg.se.wizard.control.gamestate.impl;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;

public abstract class ActionState extends State implements IActionState {


    public ActionState(GameControl controller) {
        super(controller);
    }
}
