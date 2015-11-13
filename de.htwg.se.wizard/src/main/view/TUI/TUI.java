package view.TUI;

/**
 * Created by Tamara on 13.11.2015.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.WizardController;
import controller.gameStatus;
import util.observer.IObserver;
import static java.lang.System.out;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TUI implements IObserver {

    private WizardController controller;
    private Scanner scanner;

    public TUI(WizardController controller) {
        this.controller = controller;
        controller.addObserver(this);
        this.scanner = new Scanner(System.in);
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

    public int processInputLineNumberOfPlayers(int max) {
        /* Number of players */
        String input = scanner.next();
        int players = 0;
        if (input.matches("q")) {
            return -1;
        } else if (input.matches("[2-" + max + "]")) {
            players = Integer.parseInt(input);
            return players;
        }

        return 0;
    }

    public boolean processInputLineNames() {
        String input = scanner.next();
        if (input.matches("q")) {
            return true;
        }
        controller.addPlayer(input);

        return false;
    }
}
