package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.model.player.Player;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Jan on 14.01.2016.
 */
public class GameEndState extends ActionState {

    List<Player> playerRanking;

    public GameEndState(GameControl controller) {
        super(controller);

        this.playerRanking = this.controller.getPlayer();
    }

    @Override
    public void action() {


        playerRanking.sort((o1, o2) -> o2.getScore() - o1.getScore());

        System.out.println("And The winner is!!!!!");
        int i = 1;
        for (Player player : playerRanking) {
            System.out.printf("%d . : %s\t - %d%n", i, player.getName(), player.getScore());
            i++;
        }
    }

    public List<Player> getPlayerRankint() {
        return this.playerRanking;
    }

    @Override
    public String toString() {
        return "GAMEEND";
    }
}
