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

    private void printTUI() {
        if (controller.getStatus() == gameStatus.START) {
            startGame();
        }
    }

    private void startGame() {
        //get no players, names

    }
}
