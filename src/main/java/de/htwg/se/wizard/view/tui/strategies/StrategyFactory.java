package de.htwg.se.wizard.view.tui.strategies;

import de.htwg.se.wizard.view.tui.TextUI;
import de.htwg.se.wizard.view.tui.strategies.impl.PreparingStrategy;
import de.htwg.se.wizard.view.tui.strategies.impl.TUIStrategy;

/**
 * Created by Jan on 01.01.2016.
 */
public class StrategyFactory {

    public static TUIStrategy createStrategy(String strategyName, TextUI tui) {
        TUIStrategy strategy;
        switch (strategyName) {
            case "PREPARING":
                strategy = new PreparingStrategy(tui);
                break;
            default:
                throw new IllegalArgumentException("No matched Strategy");
        }

        return strategy;
    }

}
