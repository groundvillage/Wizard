package model.card;


import java.util.Random;

/**
 * Created by Jan on 25.10.2015.
 */
public class CardDeck {

    private Card[] cards;

    public CardDeck(final int numberCards) {
        cards = new Card[numberCards];
        for (int i = 0; i < cards.length; i++) {
            cards[i] = this.getRandomCard();
        }
    }

    private Card getRandomCard() {
        int randomNumber = new Random().nextInt(10);
        if (randomNumber > 8) {
            return new SpecialCard();
        } else {
            return new NormalCard();
        }
    }
}
