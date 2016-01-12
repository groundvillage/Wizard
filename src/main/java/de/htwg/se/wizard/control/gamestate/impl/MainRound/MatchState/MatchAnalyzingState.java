package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;

public class MatchAnalyzingState extends ActionSubState {

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
