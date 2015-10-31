package model.card;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class NormalCard extends AbstractCard{

    public enum CardColor {HEARTH, TILE, CLOVER, PIKE};


    private int value;
    private CardColor color;

    public NormalCard() {
        NormalCardParameter cardParameter = this.getRandomValues();

        this.value = cardParameter.valueParameter;
        this.color = cardParameter.colorParameter;
    }

    public int getValue() {
        return this.value;
    }

    public CardColor getColor() {
        return this.color;
    }

    private NormalCardParameter getRandomValues() {

        CardColor[] CardColorValues = CardColor.values();
        Random rmd = new Random();

        int randomColorNumber = rmd.nextInt(CardColorValues.length);
        CardColor randomColor = CardColorValues[randomColorNumber];

        int randomValue = rmd.nextInt(12) + 2;

        return new NormalCardParameter(randomValue, randomColor);
    }

    public String toString() {

        StringBuilder sb = new StringBuilder("NormalCard: ");
        sb.append(this.color);
        sb.append(" - ");
        sb.append(this.value);

        return sb.toString();
    }

    private class NormalCardParameter {

        private int valueParameter;
        private CardColor colorParameter;

        public NormalCardParameter(final int value, final CardColor color) {
            valueParameter = value;
            colorParameter = color;
        }
    }
}
