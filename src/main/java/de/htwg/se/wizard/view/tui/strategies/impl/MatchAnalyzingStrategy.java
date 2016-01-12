package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;

/**
 * Created by Jan on 12.01.2016.
 */
public class MatchAnalyzingStrategy extends TUIStrategy {

    public MatchAnalyzingStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {

    }

    @Override
    public String toString(){
        return "MATCH_ANALYZING";
    }
}
