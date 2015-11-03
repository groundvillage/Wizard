package java.model.player;

/**
 * Created by Jan on 23.10.2015.
 */
public class Player {

    private String name;
    private int score;

    public Player(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
