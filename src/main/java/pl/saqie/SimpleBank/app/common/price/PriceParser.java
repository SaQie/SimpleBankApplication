package pl.saqie.SimpleBank.app.common.price;

import java.math.BigDecimal;
import java.text.ParseException;

public interface PriceParser {

    BigDecimal parserPrice(String price) throws ParseException;

}
