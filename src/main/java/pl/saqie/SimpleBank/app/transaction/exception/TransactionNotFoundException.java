package pl.saqie.SimpleBank.app.transaction.exception;

public class TransactionNotFoundException extends Exception{

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
