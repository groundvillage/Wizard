package de.htwg.se.wizard.model.card;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Jan on 25.10.2015.
 */
public class CardDeck {

    private final Card[] basicCards;
    private List<Card> usingCards;
    private Random rmd = new Random();

    public CardDeck() {
        List<Card> basicCardList = new ArrayList<>();

        NormalCard.CardColor.values();
        for (NormalCard.CardColor color: NormalCard.CardColor.values()) {
            for (int i = 2; i <= 13; i++) {
                basicCardList.add(new NormalCard(new NormalCard.NormalCardParameter(i, color)));
            }
        }
        for (SpecialCard.CardType cardType: SpecialCard.CardType.values()) {
            for (int i = 0; i < 4; i++) {
                basicCardList.add(new SpecialCard(new SpecialCard.SpecialCardParameter(cardType)));
            }
        }

        basicCards = (Card[])basicCardList.toArray();

        reset();
    }

    public void reset() {
        usingCards = new ArrayList<>();

        for  (Card c : basicCards) {
            usingCards.add(c);
        }
    }

    public Card drawCard() {
        if (usingCards.isEmpty()) {
            return null;
        }
        int cardNumber = rmd.nextInt(usingCards.size());

        Card randomCard = usingCards.get(cardNumber);

        usingCards.remove(cardNumber);

        return randomCard;
    }

    public List<Card> drawCard(int count) {
        List<Card> cardList = new LinkedList<Card>();

        for (int i = 0; i < count; i++) {
            cardList.add(this.drawCard());
        }

        return cardList;
    }
}
