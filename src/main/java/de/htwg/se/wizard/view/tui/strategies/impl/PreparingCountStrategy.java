package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PlayerCountState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;


public class PreparingCountStrategy extends TUIStrategy {

    public PreparingCountStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        IState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        System.out.printf("How many are playing? (2-%d) or q to quit%n", ((PlayerCountState) subState).getMaxCount());
    }

    @Override
    public void progressUserInput(String line) {
        if (line.matches("")) {
            //TODO Pattern für NumberOfPlayer einsetzen.
        } else {
            super.progressUserInput(line);
        }

    }

    @Override
    public String toString() {
        return "PREPARING_COUNT";
    }

}
