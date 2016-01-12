package de.htwg.se.wizard.model.card.carddeck;

import de.htwg.se.wizard.model.card.ICard;

import java.util.List;


public class DynamicCardDeck implements IBasicCardDeck {

    private final List<ICard> basicCards;

    public DynamicCardDeck(List<ICard> cards) {
        basicCards = cards;
    }

    @Override
    public List<ICard> getDeck() {
        return basicCards;
    }
}
