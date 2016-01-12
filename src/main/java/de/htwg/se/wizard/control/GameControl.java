package de.htwg.se.wizard.control;

import de.htwg.se.util.observer.Observable;
import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
import de.htwg.se.wizard.model.player.Player;

import java.util.LinkedList;
import java.util.List;

public class GameControl extends Observable {


    private int numberOfPlayers;
    private List<Player> players;

    private IState state;

    public GameControl() {

        this.players = new LinkedList<>();
        this.state = new PreparingState(this);
    }

    public void setGameState(IState state) {
        this.state = state;
        System.out.println("GameControl - GameState: " + this.state.toString());
        notifyObservers();
    }

    public void quit() {
        System.exit(1);
    }


    public void handle(String userInput) {
        if (this.state instanceof IUserInputState) {
            ((IUserInputState)this.state).handleUserInput(userInput);
        } else {
            System.out.println("Sollte wohl nicht sein");
        }
    }

    public IState getGameState() {
        return this.state;
    }

    public void updateObserver() {
        System.out.println("Observer update");
        notifyObservers();
    }

    public void setNameOfPlayers(String[] names) {
        for (String name : names) {
            this.players.add(new Player(name));
        }
    }

    public List<Player> getPlayer() {
        return this.players;
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
