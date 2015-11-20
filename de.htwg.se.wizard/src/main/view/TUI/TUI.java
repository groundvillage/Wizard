package view.TUI;

/**
 * Created by Tamara on 13.11.2015.
 */

import java.util.Scanner;
import controller.WizardController;
import controller.gameStatus;
import util.observer.IObserver;
import static java.lang.System.out;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TUI implements IObserver {

    private WizardController controller;

    public TUI(WizardController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public void update() {
        printTUI();
    }

    public void printTUI() {
        if (controller.getStatus() == gameStatus.PREDICTION) {
            //print prediction TUI
        } else if (controller.getStatus() == gameStatus.MATCH) {
            //print match TUI
        }
    }

    public boolean processInputLine(String line) {
        return false;
    }

    public int processInputLineNumberOfPlayers(int max, String line) {
        /* Number of players */
        if (line.matches("q")) {
            return -1;
        } else if (line.matches("[2-" + max + "]")) {
            int players = Integer.parseInt(line);
            return players;
        }

        return 0;
    }

    public boolean processInputLineNames(String line) {
        if (line.matches("q")) {
            return true;
        }
        controller.addPlayer(line);

        return false;
    }
}
