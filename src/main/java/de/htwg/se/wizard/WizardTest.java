package de.htwg.se.wizard;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.view.gui.GUIThreadTest;
import de.htwg.se.wizard.view.tui.TextUI;

import java.util.Scanner;

/**
 * Created by Jan on 30.12.2015.
 */
public class WizardTest {

    static Scanner scanner;
    static int maxPlayers = 6;



    public static void main(String[] args) {

        GameControl gc = new GameControl();

        TextUI tui = new TextUI(gc);

        GUIThreadTest gtt = new GUIThreadTest(gc);
        gtt.start();

        tui.update();

        gc.startGame();


    }




}
