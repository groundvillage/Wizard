package de.htwg.se.wizard.control.gamestate.impl.PreparingState;

import de.htwg.se.wizard.control.gamestate.IMainState;
import de.htwg.se.wizard.control.gamestate.IState;


/**
 * Created by Jan on 10.01.2016.
 */
public class PlayerNameSubState implements IState {

    private PreparingState gameState;
    private int currentPlayer = 0;
    private String[] nameList;

    public PlayerNameSubState(IMainState gameState) {
        this.gameState = (PreparingState) gameState;

        nameList = new String[this.gameState.getCountOfPlayer()];
    }

    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public void handleUserInput(String userInput) {
        System.out.println(userInput);

        nameList[currentPlayer] = userInput;
        currentPlayer++;
        if (currentPlayer >= this.nameList.length) {
            this.gameState.setNameOfPlayers(nameList);
        } else {
            this.gameState.handle();
        }
    }

    @Override
    public String getState() {
        return null;
    }

    @Override
    public String toString() {
        return "PREPARING-PLAYERNAME";
    }

}
