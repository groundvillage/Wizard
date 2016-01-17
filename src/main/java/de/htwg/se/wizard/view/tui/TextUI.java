package de.htwg.se.wizard.view.tui;

import de.htwg.se.util.observer.IObserver;
import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.tui.strategies.StrategyFactory;
import de.htwg.se.wizard.view.tui.strategies.impl.TUIStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextUI implements IObserver {

    private GameControl controller;
    private TUIStrategy strategy;

    public TextUI(GameControl controller) {

        this.controller = controller;
        controller.addObserver(this);

        strategy = StrategyFactory.createStrategy(controller.getGameState().toString(), this);
    }

    public void handleUserInput(String userInput) {
        controller.handle(userInput);
    }

    public GameControl getGameControl() {
        return this.controller;
    }

    @Override
    public void update() {

        String gameStateName = controller.getGameState().toString();

        if (! gameStateName.equals(strategy.toString())) {
            this.strategy = StrategyFactory.createStrategy(gameStateName, this);
        }

        this.strategy.execute();

    }

}
