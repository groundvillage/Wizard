package de.htwg.se.wizard.model.card;

/**
 * Created by Jan on 23.10.2015.
 */
public class NormalCard implements ICard {
    public static final int MAX_CARD_VALUE = 13;
    public static final int MIN_CARD_VALUE = 2;

    public enum CardValue {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        KNAVE(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private int value;

        CardValue(int value){
            this.value = value;
        }

        int getValue() {
            return value;
        }


    }

    public enum CardColor {
        HEART,
        TILE,
        CLOVER,
        PIKE
    }

    private final CardValue value;
    private final CardColor color;

    public NormalCard(final CardColor color, final CardValue value) {

        this.value = value;
        this.color = color;
    }


    public CardValue getValue() {
        return this.value;
    }

    public CardColor getColor() {
        return this.color;
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.color);
        sb.append(" - ");
        sb.append(this.value);
        sb.append(" ]");

        return sb.toString();
    }
}
