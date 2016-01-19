package de.htwg.se.wizard.model.carddeck;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.SpecialCard;
import de.htwg.se.wizard.model.card.impl.NormalCard.CardColor;
import de.htwg.se.wizard.model.card.impl.NormalCard.CardValue;

import de.htwg.se.wizard.model.carddeck.impl.CardDeck;
import de.htwg.se.wizard.model.carddeck.impl.DynamicCardDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jan on 12.11.2015.
 */
public class CardDeckTest {

    CardDeck cardDeck;
    SpecialCard wizardCard = new SpecialCard(new SpecialCard.SpecialCardParameter(SpecialCard.CardType.WIZARD));
    NormalCard normalCard = new NormalCard(CardColor.HEART, CardValue.ACE);

    @Before
    public void setUp() throws Exception {
        List<ICard> cardList = new LinkedList<>();
        cardList.add(wizardCard);
        DynamicCardDeck dynCardDeck = new DynamicCardDeck(cardList);
        cardDeck = new CardDeck(dynCardDeck);
    }

    private void createMultipleCardsDeck() {
        List<ICard> cardList = new LinkedList<>();
        cardList.add(wizardCard);
        cardList.add(normalCard);
        DynamicCardDeck dynCardDeck = new DynamicCardDeck(cardList);
        cardDeck = new CardDeck(dynCardDeck);


    }

    @Test(expected=IllegalArgumentException.class)
    public void testStandartWizardCardDeckConstructor() throws Exception {
        cardDeck = new CardDeck(1);

        assertEquals(1, cardDeck.drawMultipleCards(1).size());
        cardDeck = new CardDeck(1);
        cardDeck.drawMultipleCards(10);
    }

    @Test
    public void testDrawCard() throws Exception {
        assertEquals(wizardCard, cardDeck.drawCard());
        assertEquals(null, cardDeck.drawCard());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDrawMultipleCards() throws Exception {
        boolean drawWizardCard = false, drawNormalCard = false;

        createMultipleCardsDeck();

        List<ICard> drawnCardList = cardDeck.drawMultipleCards(2);
        assertEquals(2, drawnCardList.size());

        for (ICard card: drawnCardList) {
            if (card.equals(normalCard)) {
                drawNormalCard = true;
            } else if (card.equals(wizardCard)) {
                drawWizardCard = true;
            }
        }

        assertTrue(drawNormalCard);
        assertTrue(drawWizardCard);

        createMultipleCardsDeck();

        cardDeck.drawMultipleCards(3);

    }

    @Test
    public void testReset() throws Exception {
        createMultipleCardsDeck();

        cardDeck.drawMultipleCards(2);
        assertEquals(null, cardDeck.drawCard());

        cardDeck.reset();

        cardDeck.drawMultipleCards(2);
        assertEquals(null, cardDeck.drawCard());
    }
}