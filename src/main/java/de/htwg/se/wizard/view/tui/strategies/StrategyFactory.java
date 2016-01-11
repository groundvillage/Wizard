package de.htwg.se.wizard.view.tui.strategies;

import de.htwg.se.wizard.view.tui.TextUI;
import de.htwg.se.wizard.view.tui.strategies.impl.PreparingCountStrategy;
import de.htwg.se.wizard.view.tui.strategies.impl.PreparingNameStrategy;
import de.htwg.se.wizard.view.tui.strategies.impl.TUIStrategy;

/**
 * Created by Jan on 01.01.2016.
 */
public class StrategyFactory {

    public static TUIStrategy createStrategy(String strategyName, TextUI tui) {
        TUIStrategy strategy;
        switch (strategyName) {
            case "PREPARING_COUNT":
                strategy = new PreparingCountStrategy(tui);
                break;
            case "PREPARING_NAME":
                strategy = new PreparingNameStrategy(tui);
                break;
            default:
                throw new IllegalArgumentException("No matched Strategy");
        }

        return strategy;
    }

}
