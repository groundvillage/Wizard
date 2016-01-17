package de.htwg.se.wizard.control.gamestate.impl.preparingstate;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.StateWithSubState;
import de.htwg.se.wizard.control.gamestate.impl.UserInputSubState;

import java.util.LinkedList;
import java.util.List;


public class PlayerNameState extends UserInputSubState {

    private PreparingState gameState;
    private int currentPlayer = 0;
    private List<String> nameList;

    public PlayerNameState(GameControl controller, StateWithSubState gameState) {
        super(controller, gameState);
        this.gameState = (PreparingState) gameState;

        //nameList = new String[this.gameState.getCountOfPlayer()];
        nameList = new LinkedList<>();
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void handleUserInput(String userInput) {

        if (! nameList.contains(userInput)) {
            nameList.add(userInput);
            currentPlayer++;
        } else {
            System.out.println("bereits vorhanden");
        }
        if (currentPlayer >= this.controller.getNumberOfPlayers()) {
            this.controller.addPlayers(nameList);
            this.gameState.setNextState();
        } else {
            this.controller.updateObserver();
        }
    }

    @Override
    public String toString() {
        return "PREPARING_NAME";
    }

}
