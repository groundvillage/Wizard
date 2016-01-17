package de.htwg.se.wizard.view.tui;

/**
 * Created by Tamara on 13.11.2015.
 */

import de.htwg.se.util.observer.IObserver;
import de.htwg.se.wizard.control.WizardController;
//import de.htwg.se.wizard.control.GameStatus;
//import org.apache.log4j.Logger;

public class TUI implements IObserver {


    private WizardController controller;
    private static final String OUTPUTBORDER = "+++++++++++++++++++++++++++++++++++++++++++++++++";
    private static final String NEWLINE = System.getProperty("line.separator");
    //private Logger logger = Logger.getLogger("de.htwg.se.wizard.view.tui");

    public TUI(WizardController controller) {
        this.controller = controller;
        controller.addObserver(this);
    }

    @Override
    public void update() {

    }
/*
    @Override
    public void update() {
        printTUI();
    }

    public void printTUI() {
        List<ICard> cardsCurPlayer = controller.getCardsOfCurrentPlayer();
        List<ICard> playedCards = controller.getPlayedCards();
        int curPlayer = controller.getCurPlayer();

        logger.info(String.format("ROUND %d %s%n", controller.getCurRound(), OUTPUTBORDER));
        for (ICard c : playedCards) {
            logger.info(String.format("%s ", c.toString()));
        }
        //leere Slots einfügen
        for (int i = 0; i < controller.getNumberOfPlayers() - playedCards.size(); i++) {
            logger.info("[      ] ");
        }
        logger.info(NEWLINE);
        logger.info(OUTPUTBORDER);
        logger.info(String.format("Player %d:%n", controller.getCurPlayer() + 1));
        //Counter - only 6 cards per row
        int i = 0;
        for (ICard c : cardsCurPlayer) {
            if (i++ == 6) {
                i = 0;
                logger.info(NEWLINE);
            }
            logger.info(String.format("%s ", c.toString()));
        }
        logger.info(NEWLINE);

        /*if (controller.getStatus() == GameStatus.PREDICTION) {
            logger.info(String.format("Total: %d%n", controller.getScore(curPlayer)));
            logger.info(OUTPUTBORDER);
            logger.info(String.format("Please type in your prediction: (q to quit)"));
        } else {
            //logger.info(String.format("Prediction for this round: %d tricks\t", controller.getPrediction(curPlayer)));
            logger.info(String.format("Tricks made: %d\t", controller.getTricks(curPlayer)));
            logger.info(String.format("Total: %d%n", controller.getScore(curPlayer)));
            logger.info(NEWLINE);
            logger.info(String.format("Please type in the number of the card you want to play: (q to quit)"));
        }
        logger.info(NEWLINE);
    //}

    public boolean processInputLine(String line) {
        if ("q".equalsIgnoreCase(line)) {
            //quit
            return true;
        }
        int input;
        try {
            input = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            logger.info("Input is not a number! Try again, moron.");
            return false;
        }
        /*if (controller.getStatus() == GameStatus.PREDICTION) {
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

        logger.info(String.format("RESULTS ROUND %d %s%n", controller.getCurRound(), OUTPUTBORDER));
        for (int i=0; i < controller.getNumberOfPlayers(); i++) {
            logger.info(String.format("Player %d:%n", i + 1));
            //logger.info(String.format("Predicted: %d\tMade: %d\tPoints: %d\tTotal: %d%n", controller.getPrediction(i),
                   //controller.getTricks(i), controller.getPoints(i), controller.getScore(i)));
        }
    }

    public int processInputLineNumberOfPlayers(String line) {
        /* Number of players
        if (line.matches("q")) {
            //quit
            return - 1;
        }
        int players;
        try {
            players = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            logger.info("Invalid input! Type in a number between 2-6, you moron");
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
    */
}
