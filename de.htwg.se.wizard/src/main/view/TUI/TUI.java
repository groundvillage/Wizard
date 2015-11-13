package view.TUI;

/**
 * Created by Tamara on 13.11.2015.
 */

import java.util.Scanner;
import controller.WizardController;
import util.observer.IObserver;

public class TUI implements IObserver {

    private WizardController controller;
    private Scanner scanner;

    public TUI(WizardController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void update() {
        printTUI();
    }

    private void printTUI() {

    }


}
