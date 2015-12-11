package de.htwg.se.wizard.model.card;

import de.htwg.se.wizard.model.card.SpecialCard.CardType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by Jan on 12.11.2015.
 */
public class SpecialICardTest {

    SpecialCard specialCard;

    @Before
    public void setUp() throws Exception {
        specialCard = new SpecialCard(new SpecialCard.SpecialCardParameter(CardType.WIZARD));
    }

    @Test
    public void testGetType() throws Exception {
        assertEquals(CardType.WIZARD, specialCard.getType());
    }

    @Test
    public void testToString() throws Exception {
        String originalString = "[ WIZARD ]";
        assertEquals(originalString, specialCard.toString());
    }

    @Test
    public void testGetRandomType() {
        specialCard = new SpecialCard();
        boolean contains = false;

        for (SpecialCard.CardType ct : SpecialCard.CardType.values()) {
            if (specialCard.getType().equals(ct)) {
                contains = true;
            }
        }
        assertTrue(contains);
    }
}