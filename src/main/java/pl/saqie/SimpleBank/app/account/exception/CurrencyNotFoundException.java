package pl.saqie.SimpleBank.app.account.exception;

public class CurrencyNotFoundException extends Exception{

    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
