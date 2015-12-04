package de.htwg.se.wizard;

import de.htwg.se.wizard.model.card.CardDeck;
//import NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;

/**
 * Created by Jan on 25.10.2015.
 */
public class TestStarter {

    public static void main(String[] args) {

        CardDeck deck = new CardDeck(50);

        /*for (int i = 0; i < 10; i++) {
            NormalCard nc = new NormalCard();
            System.out.println(nc);

        }*/

        for (int i = 0; i < 10; i++) {
            SpecialCard sc = new SpecialCard();
            System.out.println(sc);
        }

    }
}
