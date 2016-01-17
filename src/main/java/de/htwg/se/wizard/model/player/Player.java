package de.htwg.se.wizard.model.player;

import de.htwg.se.wizard.model.card.ICard;
import java.util.List;
import java.util.LinkedList;

public class Player{

    private String name;
    private List<ICard> hand;
    private int score;

    public Player(String n) {
        this.name = n;
        this.score = 0;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public void dealHand(List<ICard> hand) {
        this.hand = hand;
    }

    public List<ICard> getHand() {
        return this.hand;
    }

    public ICard playCard(int number) {
        ICard tmp = this.hand.get(number);
        this.hand.remove(number);
        return tmp;
    }
}
