package de.htwg.se.wizard.control.gamestate;

public interface IState {

    void handleUserInput(String userInput);

    String toString();

}
