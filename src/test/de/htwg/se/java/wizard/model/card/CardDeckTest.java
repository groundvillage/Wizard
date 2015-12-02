package de.htwg.se.java.wizard.model.card;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jan on 12.11.2015.
 */
public class CardDeckTest {

    CardDeck cardDeck;

    @Before
    public void setUp() throws Exception {
        cardDeck = new CardDeck(1);
    }

    @Test
    public void testCardDeckConstruktor() throws Exception {
        int testSize = 50;

        cardDeck = new CardDeck(testSize);
        Card randomCard;

        boolean gotSpecialCard = false;
        boolean gotNormalCard = false;

        for (int i = 0; i < testSize; i++) {
            randomCard = cardDeck.drawCard();
            if ( randomCard instanceof SpecialCard) {
                gotSpecialCard = true;
                if (gotNormalCard) {
                    break;
                }
            } else if ( randomCard instanceof NormalCard) {
                gotNormalCard = true;
                if (gotSpecialCard) {
                    break;
                }
            }
        }
        assertTrue(gotSpecialCard);
        assertTrue(gotNormalCard);    }

    @Test
    public void testGetRandomCard() throws Exception {
        Card randomCard = cardDeck.drawCard();
        assertEquals(null, cardDeck.drawCard());
        cardDeck.setCardDeck();
        assertEquals(randomCard, cardDeck.drawCard());
    }

}