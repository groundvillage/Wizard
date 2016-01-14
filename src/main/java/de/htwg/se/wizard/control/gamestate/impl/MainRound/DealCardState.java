package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.player.Player;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;


public class DealCardState extends ActionSubState {

    private Logger logger = Logger.getLogger("de.htwg.se.wizard.control.gamestate.impl.MainRound.DealCardState");
    private MainRound gameState;

    public DealCardState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        System.out.println("DealCardState compile");
        this.gameState = (MainRound) gameState;
    }

    @Override
    public void action() {
        System.out.println("DealCard action");
        setTrumpColor();
        GameControl controller = this.gameState.getController();
        List<Player> players = controller.getPlayer();

        for (Player player : players) {
            List<ICard> cards = this.gameState.getCardDeck().drawMultipleCards(this.gameState.getCurrentRound());
            player.dealHand(cards);
            System.out.printf("%s got %d Cards%n", player.getName(), this.gameState.getCurrentRound());
        }

        this.gameState.setSubState(new PredictionState(this.controller, this.gameState));
        this.controller.notifyObservers();
    }

    private void setTrumpColor() {
        if (this.gameState.getCurrentRound() == gameState.getPeakround()) {
            gameState.setTrump(null);
        } else {
            NormalCard.CardColor[] cardColors = NormalCard.CardColor.values();
            Random r = new Random();
            int numberOfColors = cardColors.length;
            gameState.setTrump(cardColors[r.nextInt(numberOfColors)]);
        }
        logger.info("Trump for this round is " + gameState.getTrump().toString());
    }


    @Override
    public String toString() {
        return "DEAL_CARDS";
    }

}
