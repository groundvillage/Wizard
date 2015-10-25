package model.card;


import java.util.Random;

/**
 * Created by Jan on 25.10.2015.
 */
public class CardDeck {

    private Card cards[];

    public CardDeck(final int numberCards) {
        cards = new Card[numberCards];
        System.out.printf("Size of cards: %d\n", cards.length);

    }

    private Card getRandomCard() {
        int randomNumber = new Random().nextInt(10);
        System.out.printf("randomNumber: %d\n", randomNumber);
        if (randomNumber <= 9) {
            return new SpecialCard();

        } else
            return new NormalCard();

    }

}
