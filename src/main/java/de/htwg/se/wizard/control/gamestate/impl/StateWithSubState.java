package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;

public abstract class StateWithSubState extends State implements IStateWithSubState, IUserInputState {

    protected IState subState;

    public StateWithSubState(GameControl controller) {
        super(controller);
    }

    @Override
    public void setSubState(IState subState) {
        this.subState = subState;
        if (subState instanceof IActionState) {
            System.out.println("start action");
            ((IActionState) subState).action();
        }
        controller.notifyObservers();
    }

    //public void getFirstPlayer

    public IState getSubState() {
        return subState;
    }

    @Override
    public void handleUserInput(String line) {
        if (subState instanceof IUserInputState) {
            ((IUserInputState) this.subState).handleUserInput(line);
        }
    }

    @Override
    public IState getState() {
        return this.subState.getState();
    }

    @Override
    public String toString() {
        return subState.toString();
    }
}
