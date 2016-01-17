package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.impl.mainround.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate.PlayCardState;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.player.Player;
import de.htwg.se.wizard.view.tui.TextUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class PlayCardsStrategy extends TUIStrategy{

    private static final Logger LOGGER = LogManager.getLogger();

    public PlayCardsStrategy(TextUI tui) {
        super(tui);

    }

    @Override
    public void execute() {
        MainRound mainState = (MainRound) this.controller.getGameState();
        MatchState matchState = ((MatchState)((mainState).getSubState()));
        PlayCardState subState = ((PlayCardState)(matchState.getSubState()));


        LOGGER.info("------------------------------------------------");
        LOGGER.info(String.format("Trump: %s%n", mainState.getTrump()));

        if (matchState.getPrimeryCardColor() != null) {
            LOGGER.info(String.format("PriorColor: %s%n", matchState.getPrimeryCardColor()));
        } else {
            LOGGER.info("PriorColor: already not define");
        }

        LOGGER.info("Current Played Cards:");
        if (subState.getAllCurrentPlayedCards().keySet().isEmpty()) {
            LOGGER.info("already no cards played");
        } else {
            for (Player player : subState.getAllCurrentPlayedCards().keySet()) {
                LOGGER.info(String.format("%s\t: %s%n", player.getName(), subState.getAllCurrentPlayedCards().get(player)));
            }
        }

        LOGGER.info(String.format("%nPlayer: %s can play following cards:%n", subState.getCurrentPlayer().getName()));
        List<ICard> playableCards = subState.getPlayableCards();
        for (int i = 0; i < playableCards.size(); i++) {
            LOGGER.info(String.format("[%d]: %s", i, playableCards.get(i).toString()));
        }
    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }
}
