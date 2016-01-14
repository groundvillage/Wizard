package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.GameEndState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.carddeck.CardDeck;
import de.htwg.se.wizard.model.player.Player;

import java.util.HashMap;
import java.util.Map;

public class MainRound extends StateWithSubState {

    private final int MAXROUND = 19;
    private final int PEAKROUND = 10;

    private Map<Integer, Integer> predictions;
    private Map<Integer, Integer> points;
    private Map<Player, Integer> wins;
    private Map<Integer, Integer> tricks;
    private NormalCard.CardColor trump;

    private int firstPlayer;
    private int currentRound;
    private CardDeck deck;

    public MainRound(GameControl controller) {
        super(controller);

        this.firstPlayer = 0;
        this.currentRound = 1;
        this.deck = new CardDeck();
        this.predictions = new HashMap<>();
        this.wins = new HashMap<>();
        this.points = new HashMap<>();
        this.tricks = new HashMap<>();
        this.setState();
        //this.subState = new DealCardState(this.controller, this);

        for (Player player : this.controller.getPlayer()) {
            this.wins.put(player, 0);
        }
    }

    public void setTrump(NormalCard.CardColor trump) {
        this.trump = trump;
    }

    public NormalCard.CardColor getTrump() {
        return trump;
    }

    public  int getPeakround() {
        return this.PEAKROUND;
    }

    public void setState() {
        this.subState = new DealCardState(this.controller, this);
    }

    public void increaseMatchScore(Player player) {
        System.out.println("Player: "+ player);

        int score = this.wins.get(player);
        System.out.println(score);
        this.wins.replace(player, ++score);
    }

    public CardDeck getCardDeck() {
        return deck;
    }

    public int getFirstPlayer() {
        return this.firstPlayer;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public GameControl getController() {
        return this.controller;
    }

    public int cardsPerPlayer() {
        if (currentRound <= PEAKROUND) {
            return currentRound;
        }
        //after 10 rounds, cards are getting less again until 1 card in last round
        return PEAKROUND - (currentRound - PEAKROUND);
    }

    public int getLastPlayer() {
        if (this.getFirstPlayer() == 0) {
            return this.controller.getNumberOfPlayers() - 1;
        }
        return firstPlayer - 1;
    }

    public void setPrediction(int player, int prediction) {
        this.predictions.put(player, prediction);
    }

    public void nextRound() {
        if (this.firstPlayer == this.controller.getNumberOfPlayers() - 1) {
            this.firstPlayer = 0;
        }
        this.firstPlayer += 1;
    }

    @Override
    public void setNextState() {
        this.controller.setGameState(new GameEndState(this.controller));

        this.controller.notifyObservers();
    }
}
