package de.htwg.se.wizard.control.gamestate.impl.mainround;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;
import de.htwg.se.wizard.model.player.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PredictionState extends UserInputSubState {

    private static final Logger LOGGER = LogManager.getLogger(PredictionState.class.getName());
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
            Player player = this.controller.getPlayer().get(curPlayer);
            gameState.setPrediction(player, prediction);
            trickSum += prediction;
            nextPlayer();
        } else {
            LOGGER.error("Invalid prediction! Valid predictions: " + getValidPredictions().toString());
        }
    }

    private void nextPlayer() {
        if (this.curPlayer == gameState.getLastPlayer()) {
            this.gameState.setSubState(new MatchState(this.gameState));
            return;
        }
        if (this.curPlayer == this.controller.getNumberOfPlayers() - 1) {
            this.curPlayer = 0;
        } else {
            this.curPlayer += 1;
        }
    }

    public List<Integer> getValidPredictions() {
        int maxTricks = gameState.cardsPerPlayer();
        List<Integer> predictionRange = IntStream.range(0, maxTricks + 1).boxed().collect(Collectors.toList());
        if (curPlayer != gameState.getLastPlayer()) {
            LOGGER.info(predictionRange);
            return predictionRange;
        }
        predictionRange.remove(maxTricks - trickSum);
        LOGGER.info(predictionRange);
        return predictionRange;
    }


    private boolean isValid(int prediction) {
        List<Integer> validPredictions = getValidPredictions();
        return validPredictions.contains(prediction);
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
