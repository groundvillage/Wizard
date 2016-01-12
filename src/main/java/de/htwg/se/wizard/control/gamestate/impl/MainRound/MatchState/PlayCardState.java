package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.player.Player;

import java.util.List;
import java.util.Map;


public class PlayCardState extends UserInputSubState {

    private MainRound gameState;

    private int currentPlayer;
    private Map<Player, ICard> playedCards;

    public PlayCardState(GameControl controller, MainRound gameState) {
        super(controller, gameState);
        this.gameState = gameState;

        currentPlayer = this.gameState.getFirstPlayer();

        System.out.println("PlayCards");
        this.controller.updateObserver();
    }

    public ICard[] getPlayableCards() {

        ICard[] playableCards = new ICard[this.gameState.getCurrentRound()];
        List<ICard> hand = this.gameState.getController().getPlayer().get(this.currentPlayer).getHand();
        for (int i = 0; i < this.gameState.getCurrentRound(); i++) {
            playableCards[i] = hand.get(i);
        }

        return playableCards;
    }

    public void handleUserInput(String userInput) {

    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }

}
