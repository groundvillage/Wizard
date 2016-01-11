package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IGameState;
import de.htwg.se.wizard.view.tui.TextUI;
import de.htwg.se.wizard.view.tui.strategies.ITUIStrategy;

import java.util.Scanner;

/**
 * Created by Jan on 01.01.2016.
 */
public abstract class TUIStrategy implements ITUIStrategy, Runnable {

    protected GameControl controller;
    protected TextUI tui;
    protected Scanner scanner;

    public TUIStrategy(TextUI tui) {
        this.tui = tui;
        controller = tui.getGameControl();
    }

    @Override
    public void run() {
        System.out.println("run: " + this.toString());
        this.execute();
    }


    @Override
    public void execute() {
        this.scanner = new Scanner(System.in);
        //this.tui.handleUserInput(scanner.next());
    }

    @Override
    public void update() {
        if (this.scanner != null) {
            this.scanner.close();
        }
    }

    @Override
    public void progressUserInput(String line) {
        if (line.matches("q")) {
            tui.getGameControl().quit();
        }
    }
}
