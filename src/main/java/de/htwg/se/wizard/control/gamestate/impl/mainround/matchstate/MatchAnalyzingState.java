package de.htwg.se.wizard.control.gamestate.impl.mainround.matchstate;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.mainround.MainRound;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.impl.NormalCard;
import de.htwg.se.wizard.model.card.impl.SpecialCard;
import de.htwg.se.wizard.model.player.Player;

import java.util.Map;

public class MatchAnalyzingState extends ActionSubState {

    private MainRound mainState;
    private MatchState matchState;

    public MatchAnalyzingState(GameControl controller, MainRound gameState, MatchState matchState) {
        super(controller, gameState);

        this.mainState = gameState;
        this.matchState = matchState;
    }


    private void setupForNextMatch() {
        this.matchState.resetPlayedCards();
        this.matchState.resetPrimeryCardColor();
    }

    @Override
    public void action() {
        Map<Player, ICard> playedCards = this.matchState.getPlayedCards();

        Player matchWinner = null;

        Player firstFoo = null;

        int playerId = this.mainState.getFirstPlayer();

        do {

            Player player = this.controller.getPlayer().get(playerId);
            playerId++;
            if (playerId > this.controller.getNumberOfPlayers()) {
                playerId = 0;
            }

            ICard card = playedCards.get(player);
            if ( card instanceof SpecialCard ) {
                if (((SpecialCard) card).getType() == SpecialCard.CardType.WIZARD) {
                    matchWinner = player;
                    break;
                } else if (firstFoo == null){
                    firstFoo = player;
                }
            } else {
                NormalCard normalCard = (NormalCard) card;
                if (matchWinner == null) {
                    matchWinner = player;

                } else {
                    NormalCard bestCard = (NormalCard) playedCards.get(matchWinner);
                    if (bestCard.getColor() == this.mainState.getTrump() && normalCard.getColor() == this.mainState.getTrump() && normalCard.compareTo(bestCard) > 0) {
                        matchWinner = player;
                        continue;


                    } else {
                        if (normalCard.getColor() == this.mainState.getTrump()) {
                            matchWinner = player;

                        } else if (normalCard.getColor() == this.matchState.getPrimeryCardColor() && normalCard.compareTo(bestCard) > 0){
                            matchWinner = player;
                            continue;

                        }
                    }
                }
            }

        } while (playerId == this.mainState.getLastPlayer());

        if (matchWinner == null) {
            this.mainState.increaseWinningScore(firstFoo);
            System.out.printf("----------------------------Winner is: %s with %s%n", matchWinner.getName(), playedCards.get(matchWinner).toString());

        } else {
            this.mainState.increaseWinningScore(matchWinner);
            System.out.printf("----------------------------Winner is: %s with %s%n", matchWinner.getName(), playedCards.get(matchWinner).toString());

        }


        if (this.controller.getPlayer().get(this.mainState.getFirstPlayer()).getHand().isEmpty()) {
            this.matchState.setNextState();
        } else {
            setupForNextMatch();

            this.matchState.setSubState(new PlayCardState(this.controller, this.mainState, this.matchState));
        }
    }

    @Override
    public String toString() {
        return "MATCH_ANALYZING";
    }

}
