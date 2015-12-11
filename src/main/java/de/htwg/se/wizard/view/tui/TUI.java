package de.htwg.se.wizard.view.tui;

/**
 * Created by Tamara on 13.11.2015.
 */

import de.htwg.se.util.observer.IObserver;
import de.htwg.se.wizard.control.WizardController;
import de.htwg.se.wizard.model.card.ICard;

import java.util.List;

import static java.lang.System.out;

public class TUI implements IObserver {

    private WizardController controller;
    private static final String OUTPUTBORDER = "+++++++++++++++++++++++++++++++++++++++++++++++++";

    public TUI(WizardController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public void update() {
        printTUI();
    }

    public void printTUI() {
        List<ICard> cardsCurPlayer = controller.getCardsOfCurrentPlayer();
        List<ICard> playedCards = controller.getPlayedCards();
        int curPlayer = controller.getCurPlayer();

        out.printf("ROUND %d %s%n", controller.getCurRound(), OUTPUTBORDER);
        for (ICard c : playedCards) {
            out.printf("%s ", c.toString());
        }
        //leere Slots einfügen
        for (int i = 0; i < controller.getNumberOfPlayers() - playedCards.size(); i++) {
            out.printf("[      ] ");
        }
        out.println();
        out.println(OUTPUTBORDER);
        out.printf("Player %d:%n", controller.getCurPlayer() + 1);
        //Counter - only 6 cards per row
        int i = 0;
        for (ICard c : cardsCurPlayer) {
            if (i++ == 6) {
                i = 0;
                out.println();
            }
            out.printf("%s ", c.toString());
        }
        out.println();

        if (controller.getStatus() == GameStatus.PREDICTION) {
            out.printf("Total: %d%n", controller.getScore(curPlayer));
            out.println(OUTPUTBORDER);
            out.println("Please type in your prediction: (q to quit)");
        } else {
            out.printf("Prediction for this round: %d tricks\t", controller.getPrediction(curPlayer));
            out.printf("Tricks made: %d\t", controller.getTricks(curPlayer));
            out.printf("Total: %d%n", controller.getScore(curPlayer));
            out.println();
            out.println("Please type in the number of the card you want to play: (q to quit)");
        }
        out.println();
    }

    public boolean processInputLine(String line) {
        if ("q".equalsIgnoreCase(line)) {
            //quit
            return true;
        }
        int input;
        try {
            input = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            out.println("Input is not a number! Try again, moron.");
            return false;
        }
        if (controller.getStatus() == GameStatus.PREDICTION) {
            controller.predict(input);
        } else {
            controller.playCard(input);
            if (controller.getCurPlayer() == controller.getLastPlayer()) {
                printScores();
            }
        }
        return false;
    }

    private void printScores() {

        out.printf("RESULTS ROUND %d %s%n", controller.getCurRound(), OUTPUTBORDER);
        for (int i=0; i < controller.getNumberOfPlayers(); i++) {
            out.printf("Player %d:%n", i + 1);
            out.printf("Predicted: %d\tMade: %d\tPoints: %d\tTotal: %d%n", controller.getPrediction(i),
                    controller.getTricks(i), controller.getPoints(i), controller.getScore(i));
        }
    }

    public int processInputLineNumberOfPlayers(String line) {
        /* Number of players */
        if (line.matches("q")) {
            //quit
            return - 1;
        }
        int players;
        try {
            players = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            out.println("Invalid input! Type in a number between 2-6, you moron");
            return - 1;
        }
        controller.setNumberOfPlayers(players);
        return players;
    }

    public boolean processInputLineNames(String line) {
        if (line.matches("q")) {
            return true;
        }
        controller.addPlayer(line);

        return false;
    }
}
