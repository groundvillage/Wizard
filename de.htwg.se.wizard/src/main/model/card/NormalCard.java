package model.card;

import java.util.Random;

/**
 * Created by Jan on 23.10.2015.
 */
public class NormalCard extends AbstractCard{
    public static final int MAX_CARD_VALUE = 12;
    public static final int MIN_CARD_VALUE = 2;

    public enum CardColor {
        HEARTH,
        TILE,
        CLOVER,
        PIKE
    }

    private final int value;
    private final CardColor color;

    public NormalCard(final NormalCardParameter cardParameter) {

        this.value = cardParameter.getValueParameter();
        this.color = cardParameter.getColorParameter();
    }

    public NormalCard() {

        NormalCardParameter cardParameter = getRandomCardParameter();

        this.value = cardParameter.valueParameter;
        this.color = cardParameter.colorParameter;
    }

    public int getValue() {
        return this.value;
    }

    public CardColor getColor() {
        return this.color;
    }

    private CardColor getRandomColor() {
        CardColor[] cardColor = CardColor.values();

        int randomColorNumber = new Random().nextInt(cardColor.length);

        return cardColor[randomColorNumber];

    }

    private int getRandomValue() {

        return new Random().nextInt(MAX_CARD_VALUE - MIN_CARD_VALUE) + MIN_CARD_VALUE;
    }


    private NormalCardParameter getRandomCardParameter() {

        return new NormalCardParameter(this.getRandomValue(), this.getRandomColor());
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("NormalCard: ");
        sb.append(this.color);
        sb.append(" - ");
        sb.append(this.value);

        return sb.toString();
    }

    public static class NormalCardParameter {

        private int valueParameter;
        private CardColor colorParameter;

        public NormalCardParameter(final int value, final CardColor color) {
            if (value >= MIN_CARD_VALUE && value <= MAX_CARD_VALUE) {
                valueParameter = value;
                colorParameter = color;
            } else {
                throw new IllegalArgumentException(String.format("value must be between %d and %d", MIN_CARD_VALUE, MAX_CARD_VALUE));
            }
        }

        public int getValueParameter() {
            return valueParameter;
        }

        public CardColor getColorParameter () {
            return colorParameter;
        }

    }
}
