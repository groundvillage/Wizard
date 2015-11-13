package controller;

import model.player.Player;
import model.card.*;
import util.observer.Observable;

import java.util.List;
import java.util.LinkedList;
import util.observer.Observable;


/**
 * Created by Tamara on 13.11.2015.
 */
public class WizardController extends Observable {

    private gameStatus status;
    private String statusMessage;
    private List<Player> players;
    private CardDeck deck;
    private boolean quit;

    public WizardController() {
        this.status = gameStatus.START;
        this.players = new LinkedList<>();
    }

    public void addPlayer(String name) {
        this.players.add(new Player(name));
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public gameStatus getStatus() {
        return this.status;
    }

}
