package de.htwg.se.wizard.model.player;

import org.junit.Before;
import org.junit.Test;

import de.htwg.se.wizard.model.card.Card;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;
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
        NormalCard c1 = new NormalCard(new NormalCard.NormalCardParameter(3, NormalCard.CardColor.CLOVER));
        SpecialCard c2 = new SpecialCard(new SpecialCard.SpecialCardParameter(SpecialCard.CardType.WIZARD));
        List<Card> hand = new LinkedList<>();
        hand.add(c1);
        hand.add(c2);
        player.dealHand(hand);

        for (Card c : player.getHand()) {
            assertTrue(c1.equals(c) || c2.equals(c));
        }
    }
}
