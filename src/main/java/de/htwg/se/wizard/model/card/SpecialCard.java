package de.htwg.se.wizard.model.card;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class SpecialCard extends AbstractCard {

    public enum CardType {
        WIZARD,
        FOOL
    }
    private CardType type;

    public SpecialCard() {
        SpecialCardParameter cardParameter = this.getRandomCardParameter();

        type = cardParameter.getTypeParameter();
    }


    public SpecialCard(final SpecialCardParameter cardParameter) {
        this.type = cardParameter.getTypeParameter();
    }

    public CardType getType() {
        return this.type;
    }

    private CardType getRandomType() {
        CardType[] typeValeus = CardType.values();

        int randomTypeNumber = new Random().nextInt(typeValeus.length);
        return typeValeus[randomTypeNumber];
    }

    private SpecialCardParameter getRandomCardParameter() {

        return new SpecialCardParameter(this.getRandomType());
    }

    public static class SpecialCardParameter {

        private CardType typeParameter;

        public SpecialCardParameter(final CardType type) {
            typeParameter = type;
        }

        public CardType getTypeParameter() {
            return typeParameter;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SpecialCard : ");
        sb.append(this.getType());

        return sb.toString();
    }
}
