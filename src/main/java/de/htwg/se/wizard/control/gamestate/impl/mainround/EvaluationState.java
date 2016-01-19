package de.htwg.se.wizard.control.gamestate.impl.mainround;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.IStateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.model.player.Player;

import java.util.Map;


public class EvaluationState extends ActionSubState {


    public EvaluationState(GameControl controller, IStateWithSubState mainState) {
        super(controller, mainState);
    }

    @Override
    public void action() {

        Map<Player, Integer> wins = ((MainRound)this.mainState).getWins();
        Map<Player, Integer> predictions = ((MainRound)this.mainState).getPredictinons();

        this.controller.getPlayer().stream().filter(player -> wins.get(player).equals(predictions.get(player))).forEach(player -> {
            if (predictions.get(player) == 0) {
                player.increaseScore(5);
            } else {
                player.increaseScore(10 * predictions.get(player));
            }
        });

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
