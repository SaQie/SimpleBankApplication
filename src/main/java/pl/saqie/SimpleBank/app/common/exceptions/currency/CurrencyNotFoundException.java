package pl.saqie.SimpleBank.app.common.exceptions.currency;

public class CurrencyNotFoundException extends Exception{

    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
