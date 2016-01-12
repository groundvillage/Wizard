package de.htwg.se.wizard.model.card.carddeck;

import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;

import java.util.LinkedList;
import java.util.List;


public class StandartWizardCardDeck implements IBasicCardDeck {


    private final List<ICard> basicCards;

    public StandartWizardCardDeck() {
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

        basicCards = basicCardList;
    }


    @Override
    public List<ICard> getDeck() {
        return basicCards;
    }
}
