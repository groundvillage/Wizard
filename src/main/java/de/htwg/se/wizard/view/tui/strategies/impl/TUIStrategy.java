package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.tui.TextUI;
import de.htwg.se.wizard.view.tui.strategies.ITUIStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class TUIStrategy implements ITUIStrategy {

    private static final Logger LOGGER = LogManager.getLogger();
    protected GameControl controller;
    protected TextUI tui;

    public TUIStrategy(TextUI tui) {
        this.tui = tui;
        controller = tui.getGameControl();
    }

    @Override
    public void progressUserInput(String line) {
        if (line.matches("q")) {
            LOGGER.debug("Game should shutdown");
        }
        this.controller.handle(line);
    }
}
