package de.htwg.se.wizard.view.tui.strategies;

/**
 * Created by Jan on 01.01.2016.
 */
public interface ITUIStrategy {

    public void progressUserInput(String line);

    public void update();

    public void execute();


}
