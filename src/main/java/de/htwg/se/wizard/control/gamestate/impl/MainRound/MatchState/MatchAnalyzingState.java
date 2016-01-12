package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputState;

public class MatchAnalyzingState extends UserInputState implements IActionState {

    public MatchAnalyzingState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
    }


    @Override
    public void action() {

    }

    @Override
    public String toString() {
        return "MATCH_ANALYZING";
    }
}
