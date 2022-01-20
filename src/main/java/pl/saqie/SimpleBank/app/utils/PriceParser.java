package pl.saqie.SimpleBank.app.utils;

import java.math.BigDecimal;
import java.text.ParseException;

public interface PriceParser {

    BigDecimal parserPrice(String price) throws ParseException;

}
