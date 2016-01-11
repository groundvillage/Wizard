package de.htwg.se.wizard.control.gamestate;

/**
 * Created by Jan on 10.01.2016.
 */
public interface ISubState {


    void handleUserInput(String userInput);

    String toString();

}
