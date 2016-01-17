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

    private Logger logger = LogManager.getLogger();
    private MainRound mainState;
    private MatchState matchState;

    private Player currentPlayer;
    private List<ICard> playableCards;

    public PlayCardState(GameControl controller, MainRound gameState, MatchState matchState) {
        super(controller, gameState);
        this.mainState = gameState;
        this.matchState = matchState;
        this.setCurrentPlayer(this.mainState.getFirstPlayer());

        this.controller.updateObserver();
    }

    @Override
    public void handleUserInput(String userInput) {
        int cardId = Integer.parseInt(userInput);
        if (cardId < 0 || cardId > this.currentPlayer.getHand().size()) {
            logger.error("Invalid input! Valid cards: " + this.currentPlayer.getHand().toString());
            return;
        }
        ICard card = this.currentPlayer.playCard(cardId);
        setSuitToFollowIfNecessary(card);
        this.matchState.addPlayedCards(this.currentPlayer, card);



        if (this.controller.getPlayer().indexOf(currentPlayer) != this.mainState.getFirstPlayer()) {
            this.matchState.setSubState(new MatchAnalyzingState(this.controller, this.mainState, this.matchState));
            return;
        }
        this.setCurrentPlayer(nextPlayerId(currentPlayer));
        this.controller.notifyObservers();
    }

    public Map<Player, ICard> getAllCurrentPlayedCards() {
        return this.matchState.getPlayedCards();
    }

    private int nextPlayerId(Player player) {
        int currentPlayerId = this.controller.getPlayer().indexOf(player);

        if (currentPlayerId == this.controller.getNumberOfPlayers()) {
            currentPlayerId = 0;
        }
        return ++currentPlayerId;
    }

    private void setCurrentPlayer(int playerId) {
        this.currentPlayer = this.controller.getPlayer().get(playerId);

        this.playableCards = getPlayableCardsFromPlayer(this.currentPlayer);

    }

    private List<ICard> getPlayableCardsFromPlayer(Player player) {
        List<ICard> playerPlayableCards = new LinkedList<>();
        ICard[] playableCardsFromPlayer = new ICard[this.mainState.getCurrentRound()];
        List<ICard> hand = player.getHand();

        for (int i = 0; i < hand.size(); i++) {
            ICard card = hand.get(i);
            if (this.matchState.getPrimeryCardColor() == null || card instanceof SpecialCard) {
                playerPlayableCards.add(card);
            } else if (card instanceof NormalCard && ((((NormalCard) card).getColor() == this.matchState.getPrimeryCardColor()) || ((NormalCard) card).getColor() == this.mainState.getTrump())) {
                    playerPlayableCards.add(card);
            }
        }

        if (playerPlayableCards.size() == 0) {
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
        return this.currentPlayer;
    }

    public List<ICard> getPlayableCards() {

        return this.playableCards;
    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }

}
