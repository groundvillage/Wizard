package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.PlayCardState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.player.Player;
import de.htwg.se.wizard.view.tui.TextUI;


public class PlayCardsStrategy extends TUIStrategy{

    public PlayCardsStrategy(TextUI tui) {
        super(tui);

        System.out.println("PlayCardsStrategy");
    }

    @Override
    public void execute() {
        MainRound mainState = (MainRound) this.controller.getGameState();
        MatchState matchState = ((MatchState)((mainState).getSubState()));
        PlayCardState subState = ((PlayCardState)(matchState.getSubState()));


        System.out.printf("Trump: %s%n", mainState.getTrump());

        if (matchState.getPrimeryCardColor() != null) {
            System.out.printf("PriorColor: %s%n", matchState.getPrimeryCardColor());
        } else {
            System.out.println("PriorColor: already not define");
        }

        System.out.printf("Current Played Cards:");
        for (Player player : subState.getAllCurrentPlayedCards().keySet()) {
            System.out.printf("%s/t: %s%n", player.getName(), subState.getAllCurrentPlayedCards().get(player));
        }
        System.out.printf("Player: %s can play following cards:%n", subState.getCurrentPlayer().getName());
        ICard[] playableCards = subState.getPlayableCards();
        for (int i = 0; i < playableCards.length; i++) {
            System.out.printf("[%d]: %s", i, playableCards[i].toString());
        }
    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }
}
