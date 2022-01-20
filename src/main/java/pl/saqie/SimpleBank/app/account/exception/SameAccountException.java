package pl.saqie.SimpleBank.app.account.exception;

public class SameAccountException extends Exception{

    public SameAccountException(String message) {
        super(message);
    }
}
