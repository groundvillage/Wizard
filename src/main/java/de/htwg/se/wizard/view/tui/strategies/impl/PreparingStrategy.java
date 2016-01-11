package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.ISubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerCountSubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PlayerNameSubState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
import de.htwg.se.wizard.view.tui.TextUI;

import java.util.Scanner;

/**
 * Created by Jan on 01.01.2016.
 */
public class PreparingStrategy extends TUIStrategy implements Runnable {

    public PreparingStrategy(TextUI tui) {
        super(tui);

    }

    public void execute() {

        ISubState subState = ((PreparingState) this.controller.getGameState()).getSubState();

        if (subState.toString().equals("PREPARING-PLAYERCOUNT")) {
            System.out.printf("How many are playing? (2-%d) or q to quit%n", ((PlayerCountSubState) subState).getMaxCount());
        } else if (subState.toString().equals("PREPARING-PLAYERNAME")) {
            System.out.printf("get player name %d:%n", ((PlayerNameSubState)subState).getCurrentPlayer());
        }


        scanner = new Scanner(System.in);
        tui.handleUserInput(scanner.next());
    }

    @Override
    public void update() {
        System.out.println("PreparingStrategy update");
        if (this.scanner != null) {
            this.scanner.close();
        }


    }

    @Override
    public String toString() {
        return "PREPARING";
    }

    @Override
    public void run() {
        execute();
    }
}
