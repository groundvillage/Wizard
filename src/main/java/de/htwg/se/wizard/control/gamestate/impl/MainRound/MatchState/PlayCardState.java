package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;
import de.htwg.se.wizard.model.player.Player;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;


public class PlayCardState extends UserInputSubState {

    private Logger logger = Logger.getLogger("de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.PlayCardState");
    private MainRound gameState;
    private int currentPlayer;
    private NormalCard.CardColor suitToFollow;

    public PlayCardState(GameControl controller, MainRound gameState) {
        super(controller, gameState);
        this.gameState = gameState;
        this.suitToFollow = null;
        this.currentPlayer = this.gameState.getFirstPlayer();

        System.out.println("PlayCards");
        this.controller.updateObserver();
    }

    public void handleUserInput(String userInput) {
        int cardIdx = Integer.parseInt(userInput);
        List<ICard> hand = this.controller.getHandOfPlayer(currentPlayer);
        if (cardIdx == 0 || cardIdx > hand.size()) {
            logger.error("Invalid input! Valid cards: " + hand.toString());
            return;
        }
        ICard card = hand.get(cardIdx);
        setSuitToFollowIfNecessary(card);
        //TODO: check if valid card!
    }

    private void setSuitToFollowIfNecessary(ICard card) {
        if (suitToFollow == null && !(card instanceof SpecialCard)) {
            suitToFollow = ((NormalCard) card).getColor();
        }
    }

    public ICard[] getPlayableCards() {

        ICard[] playableCards = new ICard[this.gameState.getCurrentRound()];
        List<ICard> hand = this.controller.getHandOfPlayer(currentPlayer);
        for (int i = 0; i < this.gameState.getCurrentRound(); i++) {
            playableCards[i] = hand.get(i);
        }

        return playableCards;
    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }

}
