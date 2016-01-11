package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerNameSubState;
import de.htwg.se.wizard.view.tui.TextUI;

import java.util.Scanner;

/**
 * Created by Jan on 11.01.2016.
 */
public class PreparingNameStrategy extends TUIStrategy implements Runnable{


    public PreparingNameStrategy(TextUI tui) {
        super(tui);
    }

    @Override
    public void update() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void run() {
        System.out.printf("get player name %d:%n", 3);//((PlayerNameSubState)this.controller.getGameState()subState).getCurrentPlayer());

        scanner = new Scanner(System.in);
        tui.handleUserInput(scanner.next());
    }
}
