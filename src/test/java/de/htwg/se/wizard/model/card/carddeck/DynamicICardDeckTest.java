package de.htwg.se.wizard.model.card.carddeck;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.SpecialCard;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Jan on 05.12.2015.
 */
public class DynamicICardDeckTest {

    private DynamicCardDeck cardDeck;
    private SpecialCard testCard;


    /* Setup */
    @Before
    public void setUp() throws Exception {
        testCard = new SpecialCard(new SpecialCard.SpecialCardParameter(SpecialCard.CardType.WIZARD));
        List<ICard> cardList =  new LinkedList<>();
        cardList.add(testCard);
        cardDeck = new DynamicCardDeck(cardList);
    }


    @Test
    public void testGetDeck() throws Exception {
        List<ICard> cardList = cardDeck.getDeck();
        assertEquals(1, cardList.size());
        assertEquals(testCard, cardList.get(0));
    }
}