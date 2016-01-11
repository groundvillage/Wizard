package de.htwg.se.wizard.control;

import de.htwg.se.wizard.model.player.Player;
import de.htwg.se.util.observer.Observable;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.carddeck.CardDeck;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Created by Tamara on 13.11.2015.
 */
public class WizardController extends Observable {

    private GameStatus status;
    private int curRound;
    private String statusMessage;
    private int curPlayer;
    private int firstPlayer;
    private int numberOfPlayers;

    private List<Player> players;
    private CardDeck deck;

    private List<ICard> playedCards;
    private Map<Integer, Integer> points;
    //private Map<Integer, Integer> predictions;
    private Map<Integer, Integer> tricks;

    public WizardController() {
        this.players = new LinkedList<>();
        this.curRound = 1;
        this.firstPlayer = 0;
        this.deck = new CardDeck();
    }

    /*
     * GETTERS AND SETTERS
     ******************************************************************************************************************
     */
    public int getCurPlayer() {
        return curPlayer;
    }

    public void setNumberOfPlayers(int nr) {
        this.numberOfPlayers = nr;
    }

    public int getCurRound() {
        return curRound;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public List<ICard> getPlayedCards() {
        return this.playedCards;
    }

    public int getScore(int player) {
        return players.get(player).getScore();
    }

    public int getTricks(int player) {
        return tricks.get(player);
    }

    /*public int getPrediction(int player) {
        return predictions.get(player);
    }*/

    public int getPoints(int player) {
        return points.get(player);
    }

    public int getLastPlayer() {
        return getLastPlayer(this.firstPlayer);
    }

    //Returns last player of current round
    protected int getLastPlayer(int firstPlayer) {
        if (firstPlayer == 0) {
            return this.numberOfPlayers - 1;
        }
        return firstPlayer - 1;
    }


    public void addPlayer(String name) {

        this.players.add(new Player(name));
        if (players.size() == numberOfPlayers) {
            setupNewRound();
            dealCards();
        }
    }

    public List<ICard> getCardsOfCurrentPlayer() {
        return players.get(curPlayer).getHand();
    }

    /*
     * LOGIC
     ******************************************************************************************************************
     */

    // return value indicates, if prediction is valid or not
    public void predict(int prediction) {
        //Prediction cannot be greater than number of cards
        if (prediction > cardsPerPlayer()) {
            statusMessage = "Invalid input! Prediction cannot be higher than the number of possible tricks. Moron.";
            return;
        }

        if (curPlayer == this.numberOfPlayers - 1 && isEven(prediction)) {
            statusMessage = "Invalid input! Predictions cannot come out even!";
            return;
        }
        //predictions.put(curPlayer, prediction);
        curPlayer = nextPlayer();
        statusMessage = "Player " + curPlayer + " predicted " + prediction + " tricks.";
        if (curPlayer == firstPlayer) {
            this.status = GameStatus.MATCH;
        }
        notifyObservers();

    }

    public void playCard(int card) {

        int handOfPlayer = getCardsOfCurrentPlayer().size();
        if (card < 1 || card > handOfPlayer) {
            statusMessage = "Invalid input! Number doesn't match a card. Moron.";
            return;
        }

        // card - 1 weil anwenderfreundliche Anzeige der Karten (Karte 0 ist im UI Karte 1)
        ICard played = players.get(curPlayer).playCard(card - 1);
        this.playedCards.add(played);
        curPlayer = nextPlayer();

        this.notifyObservers();
/*        if (curPlayer == getLastPlayer()) {
            sleep
            calculate results --> liste points
            reset playedCards
           gamestatus = prediction
            setupNewRound
            curRound++
            firstplayer = nextPlayer()
            update
        }*/


    }

    private void dealCards() {
        for (Player player : this.players) {
            List<ICard> cards = this.deck.drawMultipleCards(cardsPerPlayer());
            player.dealHand(cards);
        }
    }

    private int cardsPerPlayer() {
        return cardsPerPlayer(curRound, 10);
    }

    //calculates, how many cards per player are dealt in this round
    protected int cardsPerPlayer(int curRound, int peakRound) {
        if (curRound <= peakRound) {
            return curRound;
        }
        //after 10 rounds, cards are getting less again until 1 card in last round
        return peakRound - (curRound - peakRound);
    }

    //Checks, if the number of tricks (Stiche) comes out -> invalid
    private boolean isEven(int lastPrediction) {
        int sumPredictions = 0;
        /*for (int i : predictions.keySet()) {
            sumPredictions += predictions.get(i);
        }*/
        //predictions come out even, when sum equals cards per player
        // -> number of tricks (Stiche) in this round
        return sumPredictions + lastPrediction == cardsPerPlayer();
    }


    private int nextPlayer() {
        if (curPlayer == this.numberOfPlayers - 1 ) {
            return 0;
        }
        return curPlayer + 1;
    }

    private void setupNewRound() {
        //this.predictions = new HashMap<>();
        this.tricks = new HashMap<>();
        this.points = new HashMap<>();
        for (int i = 0; i < this.numberOfPlayers; i++) {
            this.tricks.put(i, 0);
            this.points.put(i, 0);
        }
        curPlayer = firstPlayer;
        this.playedCards = new LinkedList<>();
        this.status = GameStatus.PREDICTION;
    }
}