package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.carddeck.CardDeck;

import java.util.List;
import java.util.Map;

public class MainRound extends StateWithSubState implements IUserInputState {

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

    private int cardsPerPlayer() {
        return cardsPerPlayer(currentRound, 10);
    }

    protected int cardsPerPlayer(int curRound, int peakRound) {
        if (curRound <= peakRound) {
            return curRound;
        }
        //after 10 rounds, cards are getting less again until 1 card in last round
        return peakRound - (curRound - peakRound);
    }

    @Override
    public String toString() {
        return this.subState.toString();
    }
}
