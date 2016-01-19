package de.htwg.se.wizard.control.gamestate.impl;

import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.model.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEndState extends ActionState {

    Map<Integer, Player> playerRanking;

    public GameEndState(GameControl controller) {
        super(controller);
    }

    @Override
    public void action() {

        List<Player> playerList = this.controller.getPlayer();
        playerList.sort((o1, o2) -> o2.getScore() - o1.getScore());

        this.playerRanking = makeRanking(playerList);

    }

    private Map<Integer, Player> makeRanking(List<Player> playerList) {
        Map<Integer, Player> ranking = new HashMap<>();

        int rank = 1;
        for (int i = 0; i < playerList.size(); i++) {

            if ( i > 0 && playerList.get(i).getScore() != playerList.get(i - 1).getScore()) {
                rank++;
            }

            ranking.put(rank, playerList.get(i));
        }

        return ranking;
    }

    public Map<Integer, Player> getPlayerRankint() {
        return this.playerRanking;
    }

    @Override
    public String toString() {
        return "GAMEEND";
    }
}
