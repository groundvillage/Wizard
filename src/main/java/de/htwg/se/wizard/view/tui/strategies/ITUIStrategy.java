package de.htwg.se.wizard.view.tui.strategies;

/**
 * Created by Jan on 01.01.2016.
 */
public interface ITUIStrategy {

    void progressUserInput(String line);

    void execute();


}
