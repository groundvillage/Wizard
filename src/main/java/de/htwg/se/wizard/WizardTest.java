package de.htwg.se.wizard;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.tui.TextUI;


import java.util.Scanner;

public class WizardTest {

    private WizardTest() {

    }

    public static void main(String[] args) {

        boolean quit = false;

        GameControl gc = new GameControl();

        TextUI tui = new TextUI(gc);

        tui.update();

        Scanner scanner = new Scanner(System.in);
        while (! quit) {
            tui.handleUserInput(scanner.next());
        }

    }





}
