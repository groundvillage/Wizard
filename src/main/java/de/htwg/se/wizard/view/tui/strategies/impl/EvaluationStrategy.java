package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;

/**
 * Created by Jan on 14.01.2016.
 */
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
