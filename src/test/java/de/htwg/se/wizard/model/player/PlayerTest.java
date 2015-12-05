package de.htwg.se.wizard.model.player;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;
import de.htwg.se.wizard.model.card.NormalCard.CardColor;
import de.htwg.se.wizard.model.card.NormalCard.CardValue;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Tamara on 05.11.2015.
 */
public class PlayerTest {

    private Player player;

    /* Setup */
    @Before
    public void setUp() throws Exception {
        player = new Player("Phil");
    }

    @Test
    public void testGetName() {
        assertEquals(player.getName(), "Phil");
    }

    @Test
    public void testIncreaseScore() {
        assertEquals(0, player.getScore());
        player.increaseScore(10);
        assertEquals(10,player.getScore());
        player.increaseScore(10);
        assertEquals(20, player.getScore());
    }

    @Test
    public void testGetScore() {
        assertEquals(0, player.getScore());
        player.increaseScore(1);
        assertEquals(1, player.getScore());
        assertTrue(0 != player.getScore());
    }

    @Test
    public void testDealHand() {
        NormalCard c1 = new NormalCard(CardColor.CLOVER, CardValue.ACE);
        SpecialCard c2 = new SpecialCard(new SpecialCard.SpecialCardParameter(SpecialCard.CardType.WIZARD));
        List<ICard> hand = new LinkedList<>();
        hand.add(c1);
        hand.add(c2);
        player.dealHand(hand);

        for (ICard c : player.getHand()) {
            assertTrue(c1.equals(c) || c2.equals(c));
        }
    }

    @Test
    public void playCard() throws Exception {
        List<ICard> testHand = new LinkedList<>();
        ICard testCard = new SpecialCard(new SpecialCard.SpecialCardParameter(SpecialCard.CardType.WIZARD));
        testHand.add(testCard);

        player.dealHand(testHand);

        assertEquals(1, player.getHand().size());
        assertEquals(testCard, player.playCard(0));
        assertEquals(0, player.getHand().size());


    }
}
