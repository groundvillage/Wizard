package model.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Tamara on 05.11.2015.
 */
public class PlayerTest {

    private Player player;

    /* Setup */
    @Before
    public void setUp() throws Exception {
        player = new Player("Phil");
    }

    @Test
    public void testGetName() {
        assertEquals(player.getName(), "Phil");
    }

    @Test
    public void testIncreaseScore() {
        assertEquals(0, player.getScore());
        player.increaseScore(10);
        assertEquals(10,player.getScore());
        player.increaseScore(10);
        assertEquals(20, player.getScore());
    }

    @Test
    public void testGetScore() {
        assertEquals(0, player.getScore());
        player.increaseScore(1);
        assertEquals(1, player.getScore());
        assertNotEquals(0, player.getScore());
    }


}
