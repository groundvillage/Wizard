package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Jan on 12.01.2016.
 */
public class PredictionStrategy extends TUIStrategy {

    private static final Logger LOGGER = LogManager.getLogger();
    public PredictionStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "PREDICTION";
    }
}
