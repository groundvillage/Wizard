package de.htwg.se.wizard.view.tui;

import de.htwg.se.util.observer.IObserver;
import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.tui.strategies.StrategyFactory;
import de.htwg.se.wizard.view.tui.strategies.impl.TUIStrategy;

import java.util.Scanner;


public class TextUI extends Thread implements IObserver {


    private GameControl controller;
    private TUIStrategy strategy;


    public TextUI(GameControl controller) {

        this.controller = controller;
        controller.addObserver(this);

        System.out.println("TextUI Construktor");

        strategy = StrategyFactory.createStrategy(controller.getGameState().toString(), this);
    }

    public void handleUserInput(String userInput) {
        System.out.println("UserInput TUI: " + userInput);
        controller.handle(userInput);
    }

    public GameControl getGameControl() {
        return this.controller;
    }

    @Override
    public void update() {

        System.out.println("TextUI update");
        String gamestate = controller.getGameState().toString();

        if (! gamestate.equals(strategy.toString())) {
            strategy = StrategyFactory.createStrategy(gamestate, this);
        }
        strategy.update();
        new Thread(strategy).start();
    }

    public void updateStrategy() {

        //Factrory to get right strategy

        String gameStateName = controller.getGameState().toString();

        strategy = StrategyFactory.createStrategy(gameStateName, this);

    }

}
