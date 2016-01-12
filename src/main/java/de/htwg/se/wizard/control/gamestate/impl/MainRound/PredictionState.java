package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Tamara on 11.01.2016.
 */
public class PredictionState extends UserInputSubState {

    private Logger logger = Logger.getLogger("de.htwg.se.wizard.control.gamestate.impl.MainRound.PredictionState");
    private MainRound gameState;
    private int curPlayer;
    private int trickSum;

    public PredictionState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        this.gameState = (MainRound) gameState;
        this.trickSum = 0;
        this.curPlayer = this.gameState.getFirstPlayer();
    }

    public void setPrediction(int prediction) {
        if (isValid(prediction)) {
            gameState.setPrediction(curPlayer, prediction);
            nextPlayer();
        } else {

        }
    }

    private void nextPlayer() {
        if (this.curPlayer == gameState.getLastPlayer()) {
            this.gameState.setSubState(new MatchState(this.gameState));
        }
    }

    public List<Integer> getValidPredictions() {
        int maxTricks = gameState.cardsPerPlayer();
        List<Integer> predictionRange = IntStream.range(0, maxTricks).boxed().collect(Collectors.toList());
        if (curPlayer != gameState.getLastPlayer()) {
            return predictionRange;
        }
        predictionRange.remove(maxTricks - trickSum);
        return predictionRange;
    }


    private boolean isValid(int prediction) {
        List<Integer> validPredictions = getValidPredictions();
        if (validPredictions.contains(prediction)) {
            return true;
        }
        return false;
    }

    @Override
    public void handleUserInput(String userInput) {
        setPrediction(Integer.parseInt(userInput));
    }

    @Override
    public String toString() {
        return "PREDICTION";
    }

}
