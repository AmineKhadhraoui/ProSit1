package tn.gestionException;

public class PrixNegatifException extends Exception {
    public PrixNegatifException(String message) {
        super(message);
    }
}
