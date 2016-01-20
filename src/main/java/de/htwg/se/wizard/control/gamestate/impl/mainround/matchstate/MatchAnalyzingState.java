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


    Player matchWinner;
    Player firstFoo;
    Map<Player, ICard> playedCards;

    public MatchAnalyzingState(GameControl controller, MainRound gameState, MatchState matchState) {
        super(controller, gameState);

        this.mainState = gameState;
        this.matchState = matchState;

        this.matchWinner = null;
        this.firstFoo = null;

        this.playedCards = this.matchState.getPlayedCards();

    }


    private void setupForNextMatch() {
        this.matchState.resetPlayedCards();
        this.matchState.resetPrimeryCardColor();
    }

    private boolean checketBetterByNormalCard(ICard card) {

        NormalCard normalCard = (NormalCard) card;
        if (matchWinner == null) {
            return true;
        }

        NormalCard bestCard = (NormalCard) playedCards.get(matchWinner);
        /*if (normalCard.getColor() == this.mainState.getTrump()) {
            if (bestCard.getColor() == this.mainState.getTrump()) {
                if (normalCard.compareTo(bestCard) > 0) {
                    return true;
                }
                return false;
            }
            return true;
        }

        if (normalCard.getColor() == this.matchState.getPrimeryCardColor() && normalCard.compareTo(bestCard) > 0){
                    return true;
        }*/

        if (normalCard.getColor() == bestCard.getColor() && normalCard.compareTo(bestCard) > 0) {
                return true;
        }

        if (bestCard.getColor() != this.mainState.getTrump()) {
            if (bestCard.getColor() == this.mainState.getTrump() || bestCard.getColor() == this.matchState.getPrimeryCardColor()) {
                return true;
            }
            return true;
        }
        return false;
    }

    private void dealWinner() {
        if (matchWinner == null) {
            this.mainState.increaseWinningScore(firstFoo);
            System.out.println("Winner: " + firstFoo.getName());

        } else {
            this.mainState.increaseWinningScore(matchWinner);
            System.out.println("Winner: " + matchWinner.getName());
        }
    }

    @Override
    public void action() {

        for (Player player : this.mainState.getOrdertPlayerList()) {

            ICard card = playedCards.get(player);
            if ( card instanceof SpecialCard ) {
                if (((SpecialCard) card).getType() == SpecialCard.CardType.WIZARD) {
                    matchWinner = player;
                    break;
                } else if (firstFoo == null){
                    firstFoo = player;
                }
            } else {
                if (checketBetterByNormalCard(card)) {
                    matchWinner = player;
                }
            }

        }

        dealWinner();

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
