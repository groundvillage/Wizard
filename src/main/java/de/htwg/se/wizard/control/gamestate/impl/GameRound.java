package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;

import java.util.Map;

/**
 * Created by Jan on 10.01.2016.
 */
public class GameRound extends GameState {

    private Map<Integer, Integer> predictions;

    public GameRound(GameControl controller) {
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
