package pl.saqie.SimpleBank.app.transaction.service;

import java.math.BigDecimal;
import java.text.ParseException;

public interface PriceParser {

    BigDecimal parserPrice(String price) throws ParseException;

}
