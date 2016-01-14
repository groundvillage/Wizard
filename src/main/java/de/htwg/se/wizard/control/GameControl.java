package de.htwg.se.wizard.control;

import de.htwg.se.util.observer.Observable;
import de.htwg.se.wizard.control.gamestate.IActionState;
import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.IUserInputState;
import de.htwg.se.wizard.control.gamestate.impl.PreparingState.PreparingState;
//import de.htwg.se.wizard.model.card.ICard;
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

        if (this.state.getState() instanceof IActionState) {
            ((IActionState)this.state.getState()).action();
        }
        notifyObservers();
    }

    public void quit() {
        System.exit(1);
    }


    public void handle(String userInput) {
        if (this.state instanceof IUserInputState) {
            ((IUserInputState)this.state).handleUserInput(userInput);
        }
    }

    public IState getGameState() {
        return this.state;
    }

    public void updateObserver() {
        notifyObservers();
    }

    public void addPlayers(List<String> names) {
        for (String name : names) {
            this.players.add(new Player(name));
        }
    }

    public List<Player> getPlayer() {
        return this.players;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    /*public List<ICard> getHandOfPlayer(int player) {
        return players.get(player).getHand();
    }*/
}
