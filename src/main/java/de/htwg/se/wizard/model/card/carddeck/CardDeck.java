package de.htwg.se.wizard.model.card.carddeck;


import de.htwg.se.wizard.model.card.ICard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CardDeck {

    private final IBasicCardDeck basicCards;
    private List<ICard> usingCards;
    private Random rmd = new Random();

    public CardDeck() {
        basicCards = new StandartWizardCardDeck();
        reset();
    }

    public CardDeck(IBasicCardDeck basicCardDeck) {
        basicCards = basicCardDeck;
        reset();
    }

    public void reset() {
        usingCards = new ArrayList<>();

        for  (ICard c : basicCards.getDeck()) {
            usingCards.add(c);
        }
    }

    public ICard drawCard() {
        if (usingCards.isEmpty()) {
            return null;
        }
        int cardNumber = rmd.nextInt(usingCards.size());

        ICard randomCard = usingCards.get(cardNumber);

        usingCards.remove(cardNumber);

        return randomCard;
    }

    public List<ICard> drawMultipleCards(int count) {
        if (count > usingCards.size()) {
            throw new IllegalArgumentException(String.format("There are not enough card to draw %d cards (only %d cards remaining)", count, usingCards.size()));
        }

        List<ICard> cardList = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            cardList.add(this.drawCard());
        }

        return cardList;
    }
}
