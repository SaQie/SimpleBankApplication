package pl.saqie.SimpleBank.app.transaction.service.impl;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.transaction.service.PriceParser;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class PriceParserImpl implements PriceParser {


    @Override
    public BigDecimal parserPrice(String price) throws ParseException {
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.ROOT);
        format.setParseBigDecimal(true);
        return (BigDecimal) format.parse(price);
    }
}
