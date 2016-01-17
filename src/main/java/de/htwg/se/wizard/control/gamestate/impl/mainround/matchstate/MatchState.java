package de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate;


import de.htwg.se.wizard.control.gamestate.impl.mainround.EvaluationState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.mainround.MainRound;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.SpecialCard;
import de.htwg.se.wizard.model.player.Player;

import java.util.LinkedHashMap;
import java.util.Map;

public class MatchState extends StateWithSubState {

    private MainRound gameState;

    private Map<Player, ICard> playedCards;
    private NormalCard.CardColor primeryCardColor;

    private int matchRound = 0;

    public MatchState(MainRound gameState) {
        super(gameState.getController());
        this.gameState = gameState;

        this.playedCards = new LinkedHashMap<>();

        this.subState = new PlayCardState(this.controller, this.gameState, this);
        this.controller.notifyObservers();
    }

    public void increaseMatchRound() {
        this.matchRound++;
    }

    public int getCurrentMatchRound() {
        return this.matchRound;
    }

    public ICard getPlayedCardsOfPlayer(Player player) {
        return this.playedCards.get(player);
    }

    public Map<Player, ICard> getPlayedCards() {
        return playedCards;
    }

    public boolean wizardIsPlayed() {
        for (ICard card : this.playedCards.values()) {
            if (card instanceof SpecialCard && ((SpecialCard) card).getType() == SpecialCard.CardType.WIZARD) {
                return true;
            }
        }
        return false;
    }

    public void resetPlayedCards() {
        this.playedCards.clear();
    }

    public void addPlayedCards(Player player, ICard playedCard) {
        this.playedCards.put(player, playedCard);
    }

    public void setPrimeryCardColor(NormalCard.CardColor cardColor) {
        this.primeryCardColor = cardColor;
    }

    public void resetPrimeryCardColor() {
        this.primeryCardColor = null;
    }

    public NormalCard.CardColor getPrimeryCardColor() {
        return this.primeryCardColor;
    }

    @Override
    public void setNextState() {
        this.gameState.setSubState(new EvaluationState(this.controller, this.gameState));

    }
}
