package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.player.Player;

import java.util.Map;

public class MatchState extends StateWithSubState {

    private MainRound gameState;
    private IState subMatchState;

    private Map<Player, ICard> playedCards;

    public MatchState(MainRound gameState) {
        super(gameState.getController());
        this.gameState = gameState;

        subMatchState = new PlayCardState(this.controller, this.gameState);
        this.controller.notifyObservers();
    }

    public IState getSubState(){
        return subMatchState;
    }

    @Override
    public void handleUserInput(String userInput) {
        this.gameState.handleUserInput(userInput);
    }


    @Override
    public String toString() {
        return this.subMatchState.toString();
    }
}
