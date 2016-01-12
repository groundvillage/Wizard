package de.htwg.se.wizard.view.tui.strategies.impl;

import de.htwg.se.wizard.control.gamestate.IState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.MatchState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState.PlayCardState;
import de.htwg.se.wizard.view.tui.TextUI;


public class PlayCardsStrategy extends TUIStrategy{

    public PlayCardsStrategy(TextUI tui) {
        super(tui);

        System.out.println("PlayCardsStrategy");
    }

    @Override
    public void execute() {
        IState subState = ((PlayCardState)((MatchState)(((MainRound) this.controller.getGameState()).getSubState())).getSubState());

        System.out.println("execute PlayCardsStrategy: " + subState);
    }

    @Override
    public String toString() {
        return "PLAY_CARDS";
    }
}
