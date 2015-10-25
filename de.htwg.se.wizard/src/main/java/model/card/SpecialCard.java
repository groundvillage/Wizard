package model.card;

/**
 * Created by Jan on 23.10.2015.
 */
public class SpecialCard extends AbstractCard {

    public enum cardType {WIZARD, FOOL}

    private cardType type;

    public cardType getType() {
        return this.type;
    }

}
