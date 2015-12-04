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
    private List<Card> usedCards;
    private Random rmd = new Random();

    public CardDeck(final int numberCards) {
        basicCards = new Card[numberCards];
        for (int i = 0; i < basicCards.length; i++) {
            basicCards[i] = this.getRandomCard();
        }

        setCardDeck();
    }

    private Card getRandomCard() {
        int randomNumber = rmd.nextInt(100);
        if (randomNumber > 80) {
            return new SpecialCard();
        } else {
            return new NormalCard();
        }
    }

    public void setCardDeck() {
        usedCards = new ArrayList<>();

        for  (Card c : basicCards) {
            usedCards.add(c);
        }
    }

    public Card drawCard() {
        if (usedCards.isEmpty()) {
            return null;
        }
        int cardNumber = rmd.nextInt(usedCards.size());

        Card randomCard = usedCards.get(cardNumber);

        usedCards.remove(cardNumber);

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
