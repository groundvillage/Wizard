package de.htwg.se.wizard.control;

import de.htwg.se.util.observer.Observable;
import de.htwg.se.wizard.control.gamestate.IGameState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
import de.htwg.se.wizard.model.player.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jan on 30.12.2015.
 */
public class GameControl extends Observable {


    private int numberOfPlayers;
    private List<Player> players;
    private int firstPlayer = 0;

    private IGameState state;


    public GameControl() {

        System.out.println("GameControl");
        this.players = new LinkedList<>();

        this.state = new PreparingState(this);
    }


    public void setGameState(IGameState state) {
        this.state = state;
        notifyObservers();
    }

    public void startGame() {
        System.out.println("Start game");
        //this.state.handle();
    }

    public void quit() {
        System.exit(1);
    }


    public void handle(String userInput) {
        this.state.handleUserInput(userInput);
    }

    public IGameState getGameState() {
        return this.state;
    }

    public void updateObserver() {
        notifyObservers();
    }

    public void setNameOfPlayers(String[] names) {
        for (String name : names) {
            this.players.add(new Player(name));
        }
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        System.out.printf("SetNumberOfPlayers: %d%n", numberOfPlayers);
        this.numberOfPlayers = numberOfPlayers;
        //notifyObservers();
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

}
