package model.player;

/**
 * Created by Jan on 23.10.2015.
 */
public class Player {

    private String name;
    private int score;

    public Player(String n) {
        this.name = n;
        this.score = 0;
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
}
