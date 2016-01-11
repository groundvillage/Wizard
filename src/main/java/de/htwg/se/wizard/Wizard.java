package de.htwg.se.wizard;

import de.htwg.se.wizard.control.WizardController;
import de.htwg.se.wizard.view.tui.TUI;
//import org.apache.logging.log4j.;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Created by Tamara on 13.11.2015.
 */
public class Wizard {

    static Scanner scanner;
    static int maxPlayers = 6;
    String line = "";

    public static void main(String[] args) {

        //PropertyConfigurator.configure("log4j.properties");

        TUI tui = new TUI(new WizardController());
        // continue until the user decides to quit
        boolean quit = false;
        int players = 0;
        scanner = new Scanner(System.in);

        // Start Sequence
        out.println("Welcome to a new round of Wizard!");
        while (!quit) {
            out.println("How many are playing? (2-" + maxPlayers + ") or q to quit");
            players = tui.processInputLineNumberOfPlayers(maxPlayers, scanner.next());
            if (players == -1) {
                quit = true;
            } else if (players >= 2 || players <= maxPlayers) {
                break;
            }
        }
        for (int i = 1; i <= players; i++) {
            out.println("Name of player " + i + ": (q to quit)");
            quit = tui.processInputLineNames(scanner.next());
            if (quit) {
                break;
            }
        }
        tui.printTUI();

        while (!quit) {
            tui.processInputLine(scanner.next());
        }
        out.print("Ende");
        System.exit(1);
    }

}
