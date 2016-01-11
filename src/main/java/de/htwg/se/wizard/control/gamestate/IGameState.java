package de.htwg.se.wizard.control.gamestate;

/**
 * Created by Jan on 30.12.2015.
 */
public interface IGameState {


    void handle();

    void handleUserInput(String userInput);

    String getState();

    String toString();
}
