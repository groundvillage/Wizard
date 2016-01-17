package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;

public class EvaluationStrategy extends TUIStrategy {

    public EvaluationStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        System.out.println("EvaluationStrategy");
    }

    @Override
    public String toString(){
        return "EVALUATION";
    }
}
