package de.htwg.se.wizard.control.gamestate.impl.MainRound.MatchState;


import de.htwg.se.wizard.control.GameControl;
import de.htwg.se.wizard.control.gamestate.impl.ActionSubState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.EvaluationState;
import de.htwg.se.wizard.control.gamestate.impl.MainRound.MainRound;
import de.htwg.se.wizard.model.card.ICard;
import de.htwg.se.wizard.model.card.NormalCard;
import de.htwg.se.wizard.model.card.SpecialCard;
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
        System.out.println("playerId: " + playerId);

        do {

            Player player = this.controller.getPlayer().get(playerId);
            System.out.println("Player create: " + player);
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
                System.out.println("NormalCard: " + normalCard.toString());
                if (matchWinner == null) {
                    System.out.println("Set first matchWinner");
                    matchWinner = player;

                } else {
                    NormalCard bestCard = (NormalCard) playedCards.get(matchWinner);
                    if (bestCard.getColor() == this.mainState.getTrump()) {
                        if (normalCard.getColor() == this.mainState.getTrump()) {
                            if (normalCard.compareTo(bestCard) > 0) {
                                matchWinner = player;
                                System.out.println("Trump win");
                                continue;
                            }
                        }
                    } else {
                        if (normalCard.getColor() == this.mainState.getTrump()) {
                            matchWinner = player;
                            System.out.println("");
                        } else if (normalCard.getColor() == this.matchState.getPrimeryCardColor() ){
                            if (normalCard.compareTo(bestCard) > 0) {
                                matchWinner = player;
                                continue;
                            }
                        }
                    }
                }
            }

        } while (playerId != this.mainState.getLastPlayer());

        if (matchWinner == null) {
            System.out.println("First Foo should win!!");
            this.mainState.increaseMatchScore(firstFoo);
            System.out.printf("Winner is: %s with %s", matchWinner.getName(), playedCards.get(matchWinner).toString());

        } else {
            this.mainState.increaseMatchScore(matchWinner);
            System.out.printf("Winner is: %s with %s", matchWinner.getName(), playedCards.get(matchWinner).toString());

        }

        setupForNextMatch();

        if (this.mainState.getCurrentRound() == this.matchState.getCurrentMatchRound()) {
            this.mainState.setSubState(new EvaluationState(this.controller, this.mainState));
        } else {
            this.matchState.setSubState(new PlayCardState(this.controller, this.mainState, this.matchState));

        }


        this.controller.notifyObservers();

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Wollte nicht schlafen");
        }*/
    }

    @Override
    public String toString() {
        return "MATCH_ANALYZING";
    }

}
