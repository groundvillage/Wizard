package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PlayerCountState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class PreparingCountStrategy extends TUIStrategy {

    private static final Logger LOGGER = LogManager.getLogger();
    public PreparingCountStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        IState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        LOGGER.info("How many are playing? (%d-%d) or q to quit%n", ((PlayerCountState) subState).getMinCount(), ((PlayerCountState) subState).getMaxCount());
    }

    @Override
    public String toString() {
        return "PREPARING_COUNT";
    }

}
