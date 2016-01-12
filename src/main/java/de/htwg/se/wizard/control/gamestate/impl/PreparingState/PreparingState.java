package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;

public class PreparingState extends StateWithSubState {

    private static final int MAX_COUNT = 6;
    private static final int MIN_COUNT = 2;

    public PreparingState(GameControl controller) {
        super(controller);

        this.subState = new PlayerCountState(this.controller, this, MAX_COUNT);
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        controller.setNumberOfPlayers(numberOfPlayers);
    }

    public int getCountOfPlayer() {
        return this.controller.getNumberOfPlayers();
    }

    public void setNameOfPlayers(String[] namesOfPlayers){
        this.controller.setNameOfPlayers(namesOfPlayers);

        this.controller.setGameState(new MainRound(this.controller));
    }

}


