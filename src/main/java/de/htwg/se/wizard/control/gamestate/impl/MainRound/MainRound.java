package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.carddeck.CardDeck;

import java.util.Map;

public class MainRound extends StateWithSubState implements IUserInputState {

    static final int MAXROUND = 19;
    static final int PEAKROUND = 10;

    private Map<Integer, Integer> predictions;
    private Map<Integer, Integer> points;
    private Map<Integer, Integer> tricks;

    private int firstPlayer;
    private int currentRound;
    private CardDeck deck;

    public MainRound(GameControl controller) {
        super(controller);

        this.firstPlayer = 0;
        this.currentRound = 1;
        this.deck = new CardDeck();
        this.setState();
        //this.subState = new DealCardState(this.controller, this);

    }

    public void setState() {
        this.subState = new DealCardState(this.controller, this);
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

    protected int getLastPlayer() {
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
    public String toString() {
        return this.subState.toString();
    }
}
