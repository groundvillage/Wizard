package de.htwg.se.wizard.control;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.player.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Created by Jan on 27.11.2015.
 */
public class WizardControllerTest {

    WizardController controller;

    @Before
    public void setup() {
        this.controller = new WizardController();
    }

    @Test
    public void testGetCurPlayer() {
        assertEquals(0, controller.getCurPlayer());
    }

    @Test
    public void testSetNumberOfPlayers() {
        controller.setNumberOfPlayers(5);
        assertEquals(5, controller.getNumberOfPlayers());
    }

    @Test
    public void testGetCurRound() {
        assertEquals(1,controller.getCurRound());
    }

    @Test
    public void testAddPlayer() {
        controller.setNumberOfPlayers(2);
        controller.addPlayer("Hans");
        controller.addPlayer("Wurst");
        List<ICard> cards = controller.getCardsOfCurrentPlayer();
        assertNotNull(cards);
        assertEquals(1, cards.size());
    }

    @Test
    public void testGetStatusMessage() {
        setUpScenario();
        controller.predict(100);
        String rated = "Invalid input! Prediction cannot be higher than the number of possible tricks. Moron.";
        assertEquals(rated, controller.getStatusMessage());
    }

    @Test
    public void testGetStatus() {
        setUpScenario();
        assertEquals(gameStatus.PREDICTION, controller.getStatus());
    }

    @Test
    public void testGetPlayedCards() {
        setUpScenario();
        controller.predict(1);
        controller.predict(1);
        assertEquals(gameStatus.MATCH, controller.getStatus());
        ICard card = controller.getCardsOfCurrentPlayer().get(0);
        assertNotNull(card);
        controller.playCard(1);
        assertEquals(card, controller.getPlayedCards().get(0));
    }

    private void setUpScenario() {
        controller.setNumberOfPlayers(2);
        controller.addPlayer("Hans");
        controller.addPlayer("Wurst");
    }

    @Test
    public void testGetScore() {
        setUpScenario();
        assertEquals(0, controller.getScore(0));
    }

    @Test
    public void testGetTricks() {
        setUpScenario();
        assertEquals(0, controller.getTricks(0));
    }

    @Test
    public void testGetPredictions() {
        setUpScenario();
        controller.predict(1);
        assertEquals(1, controller.getPrediction(0));
    }

/*    @Test
    public void testGetPoints() {

    }*/



/*

    private void dealCards() {
        for (Player player : this.players) {
            List<ICard> cards = this.deck.drawMultipleCards(cardsPerPlayer());
            player.dealHand(cards);
        }
    }

    public List<ICard> getCardsOfCurrentPlayer() {
        return players.get(curPlayer).getHand();
    }

    //calculates, how many cards per player are dealt in this round
    private int cardsPerPlayer() {
        if (curRound <= 10) {
            return curRound;
        }
        return 10 - (curRound - 10);
    }

    //Checks, if the number of tricks (Stiche) comes out -> invalid
    private boolean isEven(int lastPrediction) {
        int sumPredictions = 0;
        for (int i : predictions.keySet()) {
            sumPredictions += predictions.get(i);
        }
        //predictions come out even, when sum equals cards per player
        // -> number of tricks (Stiche) in this round
        if (sumPredictions + lastPrediction == cardsPerPlayer()) {
            return true;
        }
        return false;
    }

    //Returns last player of current round
    public int getLastPlayer() {
        if (curPlayer == 0) {
            return players.size() - 1;
        }
        return curPlayer - 1;
    }

    private int nextPlayer() {
        if (curPlayer == players.size() - 1 ) {
            return 0;
        }
        return curPlayer + 1;
    }*/

}
