package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.view.tui.TextUI;

/**
 * Created by Jan on 14.01.2016.
 */
public class GameEndStrategy extends TUIStrategy{

    public GameEndStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void execute() {
        System.out.println("GameZuEnde");
    }

    @Override
    public String toString(){
        return "GAMEEND";
    }
}
