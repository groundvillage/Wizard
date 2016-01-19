package de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.mainround.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.SpecialCard;
import de.htwg.se.wizard.model.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PlayCardState extends UserInputSubState {

    private static final Logger LOGGER = LogManager.getLogger();
    private MainRound mainState;
    private MatchState matchState;

    private int currentPlayerId;
    private List<Player> playerList;

    public PlayCardState(GameControl controller, MainRound gameState, MatchState matchState) {
        super(controller, gameState);
        this.mainState = gameState;
        this.matchState = matchState;
        this.currentPlayerId = 0;


        this.playerList = mainState.getOrdertPlayerList();
        this.controller.updateObserver();
    }

    @Override
    public void handleUserInput(String userInput) {
        int cardId = Integer.parseInt(userInput);
        Player currentPlayer = this.playerList.get(currentPlayerId);
        if (cardId < 0 || cardId > this.playerList.get(currentPlayerId).getHand().size()) {
            LOGGER.error("Invalid input! Valid cards: " + currentPlayer.getHand().toString());
            return;
        }
        ICard card = currentPlayer.playCard(cardId);
        setSuitToFollowIfNecessary(card);
        this.matchState.addPlayedCards(currentPlayer, card);



        if (++this.currentPlayerId == this.playerList.size()) {
            this.matchState.setSubState(new MatchAnalyzingState(this.controller, this.mainState, this.matchState));
            return;
        }
        this.controller.notifyObservers();
    }

    public Map<Player, ICard> getAllCurrentPlayedCards() {
        return this.matchState.getPlayedCards();
    }

    public List<ICard> getPlayableCardsFromPlayer(Player player) {
        List<ICard> playerPlayableCards = new LinkedList<>();
        List<ICard> hand = player.getHand();

        for (int i = 0; i < hand.size(); i++) {
            ICard card = hand.get(i);
            if (this.matchState.getPrimeryCardColor() == null || card instanceof SpecialCard) {
                playerPlayableCards.add(card);
            } else if (card instanceof NormalCard && ((((NormalCard) card).getColor() == this.matchState.getPrimeryCardColor()) || ((NormalCard) card).getColor() == this.mainState.getTrump())) {
                    playerPlayableCards.add(card);
            }
        }

        if (playerPlayableCards.isEmpty()) {
            for (ICard card : player.getHand()) {
                playerPlayableCards.add(card);
            }
        }

        return playerPlayableCards;
    }

    private void setSuitToFollowIfNecessary(ICard card) {
        if (this.matchState.getPrimeryCardColor() == null && card instanceof NormalCard && (! this.matchState.wizardIsPlayed())) {
            this.matchState.setPrimeryCardColor(((NormalCard) card).getColor());
        }
    }

    public Player getCurrentPlayer() {
        return this.playerList.get(currentPlayerId);
    }


    @Override
    public String toString() {
        return "PLAY_CARDS";
    }

}
