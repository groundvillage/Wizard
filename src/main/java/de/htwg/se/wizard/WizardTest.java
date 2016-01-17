package de.htwg.se.wizard;

import de.htwg.se.wizard.control.GameControl;
//import de.htwg.se.wizard.view.gui.GUIThreadTest;
import de.htwg.se.wizard.view.tui.TextUI;


import java.util.Scanner;

public class WizardTest {

    public static void main(String[] args) {

        //PropertyConfigurator.configure("log4j2.properties");

        boolean quit = false;

        GameControl gc = new GameControl();

        TextUI tui = new TextUI(gc);

        //GUIThreadTest gtt = new GUIThreadTest(gc);
        //gtt.start();

        tui.update();

        Scanner scanner = new Scanner(System.in);
        while (! quit) {
            tui.handleUserInput(scanner.next());
        }

    }





}
