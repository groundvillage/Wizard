package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;


public class MatchAnalyzingStrategy extends TUIStrategy {

    public MatchAnalyzingStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        return "MATCH_ANALYZING";
    }
}
