package de.htwg.se.wizard.control.gamestate;

public interface IUserInputState extends IState, ISubState{

    void handleUserInput(String userInput);


}
