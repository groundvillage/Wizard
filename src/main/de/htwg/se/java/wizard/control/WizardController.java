package de.htwg.se.java.wizard.control;

import de.htwg.se.java.wizard.model.player.Player;
import de.htwg.se.java.util.observer.Observable;

import de.htwg.se.java.wizard.model.card.Card;
import de.htwg.se.java.wizard.model.card.CardDeck;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Tamara on 13.11.2015.
 */
public class WizardController extends Observable {

    private gameStatus status;
    private int curRound;
    private String statusMessage;
    private List<Player> players;
    private CardDeck deck;
    private List<Card> playedCards;
    private int curPlayer;
    private int firstPlayer;

    public WizardController() {
        this.players = new LinkedList<>();
        this.playedCards = new LinkedList<>();
        this.curPlayer = 0;
        this.curRound = 1;
        this.status = gameStatus.PREDICTION;
        this.firstPlayer = 0;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    public int getCurRound() {
        return curRound;
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }
    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public gameStatus getStatus() {
        return this.status;
    }

    public List<Card> getPlayedCards() {
        return this.playedCards;
    }

    public List<Integer> getScores() {
        List<Integer> scores = new LinkedList<>();
        for (Player p : players) {
            scores.add(p.getScore());
        }
        return scores;
    }

    public List<Integer> getTricks() {
        List<Integer> tricks = new LinkedList<>();
        for (Player p : players) {
            tricks.add(p.getScore());
        }
        return tricks;
    }

    public List<Integer> getPredictions() {
        List<Integer> predictions = new LinkedList<>();
        for (Player p : players) {
            predictions.add(p.getPrediction());
        }
        return predictions;
    }

    // return value indicates, if prediction is valid or not
    public void predict(int prediction) {
        //Prediction cannot be greater than number of cards
        if (prediction > cardsPerPlayer()) {
            //return false;
        }

        if (curPlayer == players.size() - 1) {
            if (isEven(prediction)) {
                //return false;
            }
        }
        players.get(curPlayer).setPrediction(prediction);
    }

    public void playCard(int card) {
        //TODO
    }

    public List<Card> getCardsOfCurrentPlayer() {
        return players.get(curPlayer).getHand();
    }

    //calculates, how many cards per player are dealt in this round
    private int cardsPerPlayer() {
        if (curRound <= 10) {
            return curRound;
        }
        return 10 - (curRound - 10);
    }

    //Checks, if the number of tricks (Stiche) comes out -> invalid
    private boolean isEven(int lastPrediction) {
        int sumPredictions = 0;
        for (Player p : players) {
            //isEven() is called when the last player predicts
            if (!p.equals(players.get(getLastPlayer()))) {
                sumPredictions += p.getPrediction();
            }
        }
        //predictions come out even, when sum equals cards per player
        // -> number of tricks (Stiche) in this round
        if (sumPredictions == cardsPerPlayer()) {
            return true;
        }
        return false;
    }

    //Returns last player of current round
    public int getLastPlayer() {
        if (curPlayer == 0) {
            return players.size() - 1;
        }
        return curPlayer - 1;
    }
}
