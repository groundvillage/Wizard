package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PlayerNameState;
import de.htwg.se.wizard.control.gamestate.impl.preparingstate.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PreparingNameStrategy extends TUIStrategy{


    private static final Logger LOGGER = LogManager.getLogger();

    public PreparingNameStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {

        IState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        LOGGER.info(String.format("get player name %d:%n", ((PlayerNameState)subState).getCurrentPlayer()));

    }

    @Override
    public void progressUserInput(String line) {
        super.progressUserInput(line);
    }

    @Override
    public String toString() {
        return "PREPARING_NAME";
    }

}
