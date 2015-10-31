package model.card;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class SpecialCard extends AbstractCard {

    public enum CardType {WIZARD, FOOL}

    private CardType specialType;

    public SpecialCard() {
        this.specialType = this.getRandomValues();
    }

    public CardType getSpecialType() {
        return this.specialType;
    }

    private CardType getRandomValues() {

        CardType[] cardTypeValues = CardType.values();

        Random rmd = new Random();

        int randomTypeNumber = rmd.nextInt(cardTypeValues.length);

        return cardTypeValues[randomTypeNumber];
    }

    public String toString() {

        StringBuilder sb = new StringBuilder("SpecialCard: ");
        sb.append(this.specialType);

        return sb.toString();
    }

}
