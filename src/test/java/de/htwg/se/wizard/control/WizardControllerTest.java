package de.htwg.se.wizard.control;

import de.htwg.se.wizard.model.card.ICard;
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
        assertEquals(GameStatus.PREDICTION, controller.getStatus());
    }

    @Test
    public void testGetPlayedCards() {
        setUpScenario();
        controller.predict(1);
        controller.predict(1);
        assertEquals(GameStatus.MATCH, controller.getStatus());
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

    @Test
    public void testCardsPerPlayer() {
        assertEquals(1, controller.cardsPerPlayer(1, 10));
        assertEquals(9, controller.cardsPerPlayer(11, 10));
    }

    @Test
    public void testIsEven() {
        setUpScenario();
        controller.predict(1);
        controller.predict(0);
        String rated = "Invalid input! Predictions cannot come out even!";
        assertEquals(rated, controller.getStatusMessage());
    }

    @Test
    public void testGetCardsOfCurrentPlayer() {
        setUpScenario();
        assertNotNull(controller.getCardsOfCurrentPlayer());
    }

    @Test
    public void testGetLastPlayer() {
        controller.setNumberOfPlayers(2);
        assertEquals(1, controller.getLastPlayer(0));
        assertEquals(0, controller.getLastPlayer(1));
    }

    @Test
    public void testNextPlayer() {
        setUpScenario();
        assertEquals(0, controller.getCurPlayer());
        controller.predict(1);
        assertEquals(1, controller.getCurPlayer());
        controller.predict(1);
        assertEquals(0, controller.getCurPlayer());
    }

/*
    private int nextPlayer() {
        if (curPlayer == players.size() - 1 ) {
            return 0;
        }
        return curPlayer + 1;
    }*/

}
