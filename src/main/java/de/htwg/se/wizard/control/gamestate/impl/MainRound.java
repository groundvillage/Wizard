package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;

import java.util.Map;

/**
 * Created by Jan on 10.01.2016.
 */
public class MainRound extends MainState {

    private Map<Integer, Integer> predictions;

    public MainRound(GameControl controller) {
        super(controller);
    }

    @Override
    public void handleUserInput(String userInput) {

    }

    @Override
    public String getState() {
        return null;
    }
}
