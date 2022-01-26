package pl.saqie.SimpleBank.app.infrastructure.currency;

public enum Currencies {
    EUR("Euro"),
    USD("Dolar amerykański"),
    AUD("Dolar australijski"),
    CAD("Dolar kanadyjski"),
    CHF("Frank szwajcarski"),
    GBP("Funt szterling"),
    JPY("Jen"),
    CZK("Korona czeska"),
    DKK("Korona duńska"),
    NOK("Korona norweska"),
    SEK("Korona szwedzka");

    private final String description;

    Currencies(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
