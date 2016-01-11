package de.htwg.se.wizard.control.gamestate;


public interface IGameState {


    void handle(); //update Controller

    void handleUserInput(String userInput);

    String toString();
}
