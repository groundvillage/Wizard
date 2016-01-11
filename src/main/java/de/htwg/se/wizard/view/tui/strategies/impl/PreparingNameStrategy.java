package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerNameSubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;


public class PreparingNameStrategy extends TUIStrategy implements Runnable{


    public PreparingNameStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {

        IState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        System.out.printf("get player name %d:%n", ((PlayerNameSubState)subState).getCurrentPlayer());

    }

    @Override
    public String toString() {
        return "PREPARING_NAME";
    }

}
