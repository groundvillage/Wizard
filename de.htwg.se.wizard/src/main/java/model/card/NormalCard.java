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
        this.value = value;
        this.color = color;

        this.getRandomValues();
    }

    public int getValue() {
        return this.value;
    }

    public CardColor getColor() {
        return this.color;
    }

   // private
    private NormalCardParameter getRandomValues() {
        CardColor[] blubber = CardColor.values();

        int randomColorNumber = new Random().nextInt(blubber.length);
        CardColor randomColor = blubber[randomColorNumber];

        return new NormalCardParameter(5, randomColor);
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
