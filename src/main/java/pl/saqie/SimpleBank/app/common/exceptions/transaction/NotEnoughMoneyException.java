package pl.saqie.SimpleBank.app.common.exceptions.transaction;

public class NotEnoughMoneyException extends Exception{

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
