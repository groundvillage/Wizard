package de.htwg.se.wizard.model.wizardexceptions;


public final class PlayerNameException extends RuntimeException{

    public PlayerNameException(String errorMsg) {
        super(errorMsg);
    }
}
