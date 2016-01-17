package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EvaluationStrategy extends TUIStrategy {


    private static final Logger LOGGER = LogManager.getLogger();

    public EvaluationStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        LOGGER.debug("EvaluationStrategy");
    }

    @Override
    public String toString(){
        return "EVALUATION";
    }
}
