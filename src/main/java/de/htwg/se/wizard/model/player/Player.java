package de.htwg.se.wizard.model.player;

import de.htwg.se.wizard.model.card.Card;
import java.util.List;
import java.util.LinkedList;
/**
 * Created by Jan on 23.10.2015.
 */
public class Player {

    private String name;
    private List<Card> hand;
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

    public void dealHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public Card playCard(int number) {
        Card tmp = this.hand.get(number);
        this.hand.remove(number);
        return tmp;
    }
}
