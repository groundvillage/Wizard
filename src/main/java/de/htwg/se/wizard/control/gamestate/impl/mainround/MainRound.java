package de.htwg.se.wizard.control.gamestate.impl.mainround;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.GameEndState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.carddeck.impl.CardDeck;
import de.htwg.se.wizard.model.player.Player;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainRound extends StateWithSubState {

    private static final int MAXROUND = 19;
    private static final int PEAKROUND = 10;

    private Map<Player, Integer> predictions;
    private Map<Player, Integer> wins;
    private NormalCard.CardColor trump;

    private int firstPlayer;
    private int currentRound;

    private CardDeck deck;

    public MainRound(GameControl controller) {
        super(controller);

        this.firstPlayer = 0;
        this.currentRound = 1;
        this.deck = new CardDeck(this.controller.getNumberOfPlayers());
        this.predictions = new HashMap<>();
        this.wins = new HashMap<>();
        this.setState();

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

    public void increaseWinningScore(Player player) {

        int score = this.wins.get(player);
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

    public boolean isFinalRound() {
        return currentRound == MAXROUND;
    }

    public GameControl getController() {
        return this.controller;
    }

    public int cardsPerPlayer() {
        if (currentRound <= PEAKROUND) {
            return currentRound;
        }
        return PEAKROUND - (currentRound - PEAKROUND);
    }

    public int getLastPlayer() {
        if (firstPlayer == 0) {
            return this.controller.getNumberOfPlayers() - 1;
        }
        return firstPlayer - 1;
    }

    public Map<Player, Integer> getWins() {
        return wins;
    }

    public Map<Player, Integer> getPredictinons() {
        return predictions;
    }

    public void setPrediction(Player player, int prediction) {
        this.predictions.put(player, prediction);
    }

    public List<Player> getOrdertPlayerList() {
        List<Player> players = this.controller.getPlayer();
        List<Player> ordertPlayer = new LinkedList<>();

        int playerId = firstPlayer;

        do {
            ordertPlayer.add(players.get(playerId));

            if (++playerId == players.size()) {
                playerId = 0;
            }

        } while (playerId == getLastPlayer());


        return ordertPlayer;
    }

    public void nextRound() {
        if (++this.firstPlayer == this.controller.getNumberOfPlayers()) {
            this.firstPlayer = 0;
        }

        this.currentRound++;
    }

    @Override
    public void setNextState() {

        this.controller.setGameState(new GameEndState(this.controller));

        this.controller.notifyObservers();
    }
}
