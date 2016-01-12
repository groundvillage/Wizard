package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.player.Player;

import java.util.List;


public class DealCardState extends ActionSubState {

    private MainRound gameState;

    public DealCardState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        System.out.println("DealCardState compile");
        this.gameState = (MainRound) gameState;
    }

    @Override
    public void action() {
        GameControl controller = this.gameState.getController();
        List<Player> players = controller.getPlayer();

        for (Player player : players) {
            List<ICard> cards = this.gameState.getCardDeck().drawMultipleCards(this.gameState.getRoundCounter());
            player.dealHand(cards);
            System.out.printf("%s got %d Cards%n", player.getName(), this.gameState.getRoundCounter());
        }

        this.gameState.setSubState(new PredictionState(this.controller, this.gameState));
        this.controller.notifyObservers();
    }


    @Override
    public String toString() {
        return "DEAL_CARDS";
    }

}
