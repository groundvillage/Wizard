package de.htwg.se.wizard.control.gamestate.impl.preparingstate;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.mainround.MainRound;

public class PreparingState extends StateWithSubState {

    private static final int MAX_COUNT = 6;
    private static final int MIN_COUNT = 2;

    public PreparingState(GameControl controller) {
        super(controller);

        this.subState = new PlayerCountState(this.controller, this, this.MIN_COUNT, this.MAX_COUNT);
    }

    @Override
    public void setNextState() {
        this.controller.setGameState(new MainRound(this.controller));

        this.controller.notifyObservers();
    }
}


