package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.exception.CurrencyNotFoundException;
import pl.saqie.SimpleBank.app.account.service.CurrencyService;
import pl.saqie.SimpleBank.app.infrastructure.RestClientService;
import pl.saqie.SimpleBank.app.infrastructure.currency.Currencies;
import pl.saqie.SimpleBank.app.infrastructure.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.infrastructure.dto.SingleCurrencyGeneralDto;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final RestClientService restClientService;

    @Override
    public SingleCurrencyGeneralDto getSingleCurrency(String code) throws CurrencyNotFoundException {
        checkCodeCorrect(code);
        return restClientService.callRestClientForSingleCurrency(code);
    }

    @Override
    public AllCurrenciesGeneralDto[] getAllCurrencies() {
        return restClientService.callRestClientForAllCurrencies();
    }

    private void checkCodeCorrect(String code) throws CurrencyNotFoundException {
        boolean found = false;
        for (Currencies value : Currencies.values()) {
            if (value.name().equalsIgnoreCase(code)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new CurrencyNotFoundException("Nie odnaleziono takiego kodu waluty !");
        }
    }


}
