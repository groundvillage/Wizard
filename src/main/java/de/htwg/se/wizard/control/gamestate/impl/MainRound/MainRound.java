package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.carddeck.CardDeck;

import java.util.Map;

public class MainRound extends StateWithSubState implements IUserInputState {

    private Map<Integer, Integer> predictions;
    private int currentPlayer;
    private int roundCounter;

    private CardDeck deck;

    public MainRound(GameControl controller) {
        super(controller);

        this.currentPlayer = 0;
        this.roundCounter = 1;
        this.deck = new CardDeck();

        this.subState = new DealCardState(this.controller, this);
    }

    public CardDeck getCardDeck() {
        return deck;
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public GameControl getController() {
        return this.controller;
    }

    @Override
    public String toString() {
        return this.subState.toString();
    }
}
