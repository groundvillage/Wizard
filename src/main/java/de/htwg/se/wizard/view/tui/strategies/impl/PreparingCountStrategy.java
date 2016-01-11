package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.ISubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerCountSubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerNameSubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;

import java.util.Scanner;

/**
 * Created by Jan on 01.01.2016.
 */
public class PreparingCountStrategy extends TUIStrategy {

    public PreparingCountStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        ISubState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        System.out.printf("How many are playing? (2-%d) or q to quit%n", ((PlayerCountSubState) subState).getMaxCount());
    }

    @Override
    public String toString() {
        return "PREPARING_COUNT";
    }

}
