package de.htwg.se.wizard.model.carddeck.impl;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.SpecialCard;
import de.htwg.se.wizard.model.carddeck.IBasicCardDeck;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class StandartWizardCardDeck implements IBasicCardDeck {


    private final List<ICard> basicCards;

    public StandartWizardCardDeck(int numberOfCards) {
        List<ICard> basicCardList = new LinkedList<>();

        NormalCard.CardColor.values();
        for (NormalCard.CardColor color: NormalCard.CardColor.values()) {
            for (NormalCard.CardValue value: NormalCard.CardValue.values()) {
                basicCardList.add(new NormalCard(color, value));
            }
        }



        for (SpecialCard.CardType cardType: SpecialCard.CardType.values()) {
            for (int i = 0; i < 4; i++) {
                basicCardList.add(new SpecialCard(new SpecialCard.SpecialCardParameter(cardType)));
            }
        }

        for (int i = 0; i < (60 - numberOfCards); i++) {
            int randomInt = new Random().nextInt(basicCardList.size());
            basicCardList.remove(randomInt);
        }

        basicCards = basicCardList;
    }


    @Override
    public List<ICard> getDeck() {
        return basicCards;
    }
}
