package de.htwg.se.wizard.control;

import de.htwg.se.wizard.model.player.Player;
import de.htwg.se.util.observer.Observable;

import de.htwg.se.wizard.model.card.Card;
import de.htwg.se.wizard.model.card.CardDeck;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by Tamara on 13.11.2015.
 */
public class WizardController extends Observable {

    private gameStatus status;
    private int curRound;
    private String statusMessage;
    private int curPlayer;
    private int firstPlayer;

    private List<Player> players;
    private CardDeck deck;

    private List<Card> playedCards;
    private Map<Integer, Integer> points;
    private Map<Integer, Integer> predictions;
    private Map<Integer, Integer> tricks;

    public WizardController() {
        this.players = new LinkedList<>();
        this.playedCards = new LinkedList<>();
        this.points = new HashMap<>();
        this.predictions = new HashMap();
        this.tricks = new HashMap();
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

    public int getScore(int player) {
        return players.get(player).getScore();
    }

    public int getTricks(int player) {
        return tricks.get(player);
    }

    public int getPrediction(int player) {
        return predictions.get(player);
    }

    public int getPoints(int player) {
        return points.get(player);
    }

    // return value indicates, if prediction is valid or not
    public void predict(int prediction) {
        //Prediction cannot be greater than number of cards
        if (prediction > cardsPerPlayer()) {
            statusMessage = "Invalid input! Prediction cannot be higher than the number of possible tricks. Moron.";
            return;
        }

        if (curPlayer == players.size() - 1) {
            if (isEven(prediction)) {
                statusMessage = "Invalid input! Predictions cannot come out even!";
                return;
            }
            predictions.put(curPlayer, prediction);
            curPlayer = nextPlayer();
            statusMessage = "Player " + curPlayer + " predicted " + prediction + " tricks.";
            if (curPlayer == firstPlayer) {
                this.status = gameStatus.MATCH;
            }
            notifyObservers();
        }
    }

    public void playCard(int card) {
        int handOfPlayer = players.get(curPlayer).getHand().size();

        if (card < 1 || card > handOfPlayer) {
            statusMessage = "Invalid input! Number doesn't match a card. Moron.";
            return;
        }

        Card played = players.get(curPlayer).playCard(card);
        this.playedCards.add(played);
        this.notifyObservers();
/*        if (curPlayer == getLastPlayer()) {
              sleep
              calculate results --> liste points
              reset playedCards
              gamestatus = prediction
              reset predictions
              curRound++
              firstplayer = nextPlayer()
              update
          }
       */

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
        for (int i : predictions.keySet()) {
            sumPredictions += predictions.get(i);
        }
        //predictions come out even, when sum equals cards per player
        // -> number of tricks (Stiche) in this round
        if (sumPredictions + lastPrediction == cardsPerPlayer()) {
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

    private int nextPlayer() {
        if (curPlayer == players.size() - 1 ) {
            return 0;
        }
        return curPlayer + 1;
    }
}