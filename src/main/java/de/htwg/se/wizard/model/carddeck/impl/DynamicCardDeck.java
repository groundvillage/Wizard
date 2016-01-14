package de.htwg.se.wizard.model.carddeck.impl;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.carddeck.IBasicCardDeck;

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
