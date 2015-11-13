package model.card;

import model.card.NormalCard.CardColor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Jan on 04.11.2015.
 */
public class NormalCardTest{

    private NormalCard normalCard;

    @Before
    public void setUp() throws Exception {
        NormalCard.NormalCardParameter cardParameter = new NormalCard.NormalCardParameter(2, NormalCard.CardColor.HEARTH);
        normalCard = new NormalCard(cardParameter);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(2, normalCard.getValue());
    }

    @Test
    public void testGetColor() throws Exception {
        assertEquals(CardColor.HEARTH, normalCard.getColor());
    }

    @Test
    public void testToString() throws Exception {
        String originalString = "NormalCard: HEARTH - 2";
        assertEquals(originalString, normalCard.toString());
    }

    @Test
    public void testGetRandomValue() throws Exception {
        normalCard = new NormalCard();

        assertTrue(normalCard.getValue() >= normalCard.MIN_CARD_VALUE);
        assertTrue(normalCard.getValue() <= normalCard.MAX_CARD_VALUE);
    }

    @Test
    public void testGetRandomColor() throws Exception {
        normalCard = new NormalCard();
        boolean contains = false;

        for (CardColor cc : CardColor.values()) {
            if (normalCard.getColor().equals(cc)) {
                contains = true;
            }
        }
        assertTrue(contains);
    }

}