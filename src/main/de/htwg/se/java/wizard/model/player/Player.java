package de.htwg.se.java.wizard.model.player;

import de.htwg.se.java.wizard.model.card.Card;
import java.util.List;
import java.util.LinkedList;
/**
 * Created by Jan on 23.10.2015.
 */
public class Player {

    private String name;
    private List<Card> hand;
    private int score;
    private int prediction;
    private int tricks;

    public Player(String n) {
        this.name = n;
        this.score = 0;
        this.tricks = 0;
        this.hand = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        this.prediction = prediction;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    public int getTricks() {
        return tricks;
    }
    public void addTrick() {
        this.tricks++;
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

    public void reset() {
        this.tricks = 0;
        this.prediction = 0;
    }
}
