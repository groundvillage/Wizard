package de.htwg.se.wizard.view.tui;

import de.htwg.se.wizard.control.WizardController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Tamara on 18.12.2015.
 */
public class TUITest {

    TUI tui;

    @Before
    public void setup() {
       this.tui = new TUI(new WizardController());
    }

    @Test
    public void testProcessInputLineNumberOfPlayers() {
        /*int rvalue = tui.processInputLineNumberOfPlayers("q");
        assertEquals(-1, rvalue);
        rvalue = tui.processInputLineNumberOfPlayers("nonsense");
        assertEquals(-1, rvalue);
        rvalue = tui.processInputLineNumberOfPlayers("2");
        assertEquals(2, rvalue);*/
    }

    @Test
    public void testProcessInputLineNames() {
        /*boolean rvalue = tui.processInputLineNames("q");
        assertEquals(true, rvalue);
        rvalue = tui.processInputLineNames("Hans");
        assertEquals(false, rvalue);*/
    }

    @Test
    public void testProcessInputLine() {
        /*setUpScenario();
        boolean rvalue = tui.processInputLine("q");
        assertEquals(true, rvalue);
        rvalue = tui.processInputLine("nonsense");
        assertEquals(false, rvalue);
        rvalue = tui.processInputLine("1");
        assertEquals(false, rvalue);
        rvalue = tui.processInputLine("1");
        assertEquals(false, rvalue);
        rvalue = tui.processInputLine("1");
        assertEquals(false, rvalue);
    }

    private void setUpScenario() {
        tui.processInputLineNumberOfPlayers("2");
        tui.processInputLineNames("Hans");
        tui.processInputLineNames("Wurst");*/
    }
}
