package de.htwg.se.wizard.control.gamestate;


public interface IStateWithSubState extends IState {

    void setSubState(IState subState);

    IState getSubState();

}
