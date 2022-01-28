package pl.saqie.SimpleBank.app.common.exceptions.transaction;

public class TransactionNotFoundException extends Exception{

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
