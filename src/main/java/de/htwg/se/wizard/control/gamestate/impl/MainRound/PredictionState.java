package de.htwg.se.wizard.control.gamestate.impl.MainRound;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;

/**
 * Created by Tamara on 11.01.2016.
 */
public class PredictionState extends UserInputSubState {


    private MainRound gameState;

    public PredictionState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        this.gameState = (MainRound) gameState;

        System.out.println("Prediction state!!");

        this.gameState.setSubState(new MatchState(this.gameState));

        System.out.println("sollte gleich handeln");

        this.controller.notifyObservers();
    }


    @Override
    public void handleUserInput(String userInput) {

    }

    @Override
    public String toString() {
        return "PREDICTION";
    }

}
