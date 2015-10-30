package model.card;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class NormalCard extends AbstractCard {

    public enum CardColor {
        HEARTH,
        TILE,
        CLOVER,
        PIKE
    }


    private int value;
    private CardColor color;

    public NormalCard() {
        NormalCardParameter cardparameter= this.getRandomValues();

        this.value = cardparameter.getValueParameter();
        this.color = cardparameter.getColorParameter();
    }

    public int getValue() {
        return this.value;
    }

    public CardColor getColor() {
        return this.color;
    }

    private NormalCardParameter getRandomValues() {

        CardColor[] colorvalues = CardColor.values();

        int randomColorNumber = new Random().nextInt(colorvalues.length);
        CardColor randomColor = colorvalues[randomColorNumber];

        return new NormalCardParameter(5, randomColor);
    }

    private class NormalCardParameter {



        private int valueParameter;
        private CardColor colorParameter;

        public NormalCardParameter(final int value, final CardColor color) {
            valueParameter = value;
            colorParameter = color;
        }

        public int getValueParameter() {
            return valueParameter;
        }

        public CardColor getColorParameter() {
            return colorParameter;
        }
    }
}
