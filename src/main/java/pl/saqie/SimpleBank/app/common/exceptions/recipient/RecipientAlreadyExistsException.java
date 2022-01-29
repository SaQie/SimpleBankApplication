package pl.saqie.SimpleBank.app.common.exceptions.recipient;

public class RecipientAlreadyExistsException extends Exception{
    public RecipientAlreadyExistsException(String message) {
        super(message);
    }
}
