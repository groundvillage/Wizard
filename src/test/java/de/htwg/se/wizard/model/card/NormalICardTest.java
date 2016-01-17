package de.htwg.se.wizard.model.card;

import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.NormalCard.CardColor;
import de.htwg.se.wizard.model.card.impl.NormalCard.CardValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Jan on 04.11.2015.
 */
public class NormalICardTest {

    private NormalCard normalCard;

    @Before
    public void setUp() throws Exception {
        normalCard = new NormalCard(CardColor.HEART, CardValue.ACE);
    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(CardValue.ACE, normalCard.getValue());
        //assertEquals(14, normalCard.getValue().getValue());
    }

    @Test
    public void testGetColor() throws Exception {
        assertEquals(CardColor.HEART, normalCard.getColor());
    }

    @Test
    public void testToString() throws Exception {
        String originalString = "[ HEART - ACE ]";
        assertEquals(originalString, normalCard.toString());
    }
}