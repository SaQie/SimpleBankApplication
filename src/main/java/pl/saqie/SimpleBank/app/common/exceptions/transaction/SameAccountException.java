package pl.saqie.SimpleBank.app.common.exceptions.transaction;

public class SameAccountException extends Exception{

    public SameAccountException(String message) {
        super(message);
    }
}
