package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.tui.TextUI;
import de.htwg.se.wizard.view.tui.strategies.ITUIStrategy;

import java.util.Scanner;


public abstract class TUIStrategy implements ITUIStrategy {

    protected GameControl controller;
    protected TextUI tui;

    public TUIStrategy(TextUI tui) {
        this.tui = tui;
        controller = tui.getGameControl();
    }

    @Override
    public void progressUserInput(String line) {
        if (line.matches("q")) {
            tui.getGameControl().quit();
        }
    }
}
