package de.htwg.se.wizard.model.card.impl;

import de.htwg.se.wizard.model.card.ICard;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class SpecialCard implements ICard {

    public enum CardType {
        FOOL(1),
        WIZARD(2);

        private CardType(int value) {
            this.value = value;
        }

        private final int value;

        public int getValue() {
            return value;
        }

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

    public int compareTo(Object o) {

        if (o instanceof SpecialCard) {

            return this.type.getValue() - ((SpecialCard) o).getType().getValue();

        } else {
            if (this.type == CardType.FOOL) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.getType());
        sb.append(" ]");

        return sb.toString();
    }
}
