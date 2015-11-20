package model.player;

import model.card.Card;
import model.card.NormalCard;
import model.card.SpecialCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.LinkedList;

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

        hand = player.getHand();
        for (Card c : hand) {
            assertEquals(c1, c);
        }
    }


}
