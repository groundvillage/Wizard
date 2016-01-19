package de.htwg.se.wizard.model.carddeck;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.carddeck.impl.StandartWizardCardDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Jan on 05.12.2015.
 */
public class StandartWizardICardDeckTest {

    StandartWizardCardDeck cardDeck;

    @Before
    public void setUp() throws Exception {
        cardDeck = new StandartWizardCardDeck(1);
    }

    @Test
    public void testGetDeck() throws Exception {
        List<ICard> cardList = cardDeck.getDeck();
        assertEquals(1, cardList.size());
    }
}