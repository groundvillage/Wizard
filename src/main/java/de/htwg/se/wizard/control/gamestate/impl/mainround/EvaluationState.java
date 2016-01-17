package de.htwg.se.wizard.control.gamestate.impl.mainround;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.player.Player;


public class EvaluationState extends ActionSubState {


    public EvaluationState(GameControl controller, IStateWithSubState mainState) {
        super(controller, mainState);


    }

    @Override
    public void action() {
        System.out.println("Evaluation");
        int i = 0;

        for (Player player : this.controller.getPlayer()) {
            player.increaseScore(i);

            ++i;
        }

        if (! ((MainRound)this.mainState).isFinalRound()) {
            ((MainRound) this.mainState).nextRound();

            this.mainState.setSubState(new DealCardState(this.controller, (StateWithSubState) this.mainState));
        } else {
            mainState.setNextState();

        }
    }

    @Override
    public String toString() {
        return "EVALUATION";
    }
}
