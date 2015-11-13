package model.card;

import org.junit.Before;
import org.junit.Test;

import model.card.NormalCard.CardColor;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jan on 12.11.2015.
 */
public class NormalCardParameterTest {

    NormalCard.NormalCardParameter cardParameter;

    @Before
    public void setUp() throws Exception {
        cardParameter = new NormalCard.NormalCardParameter(2, CardColor.HEART);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorIllegalValue() throws Exception{
        cardParameter = new NormalCard.NormalCardParameter(1, CardColor.CLOVER);
    }


    @Test
    public void testGetValueParameter() throws Exception {
        assertEquals(2, cardParameter.getValueParameter());
    }

    @Test
    public void testGetColorParameter() throws Exception {
        assertEquals(CardColor.HEART, cardParameter.getColorParameter());

    }
}