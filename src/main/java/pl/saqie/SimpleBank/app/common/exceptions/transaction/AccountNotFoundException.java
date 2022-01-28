package pl.saqie.SimpleBank.app.common.exceptions.transaction;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException(String message) {
        super(message);
    }
}
