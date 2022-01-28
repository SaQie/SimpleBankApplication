package pl.saqie.SimpleBank.app.component.rest.service;

import pl.saqie.SimpleBank.app.component.currency.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.component.currency.dto.SingleCurrencyGeneralDto;

public interface RestClientService {

    SingleCurrencyGeneralDto callRestClientForSingleCurrency(String code);
    AllCurrenciesGeneralDto[] callRestClientForAllCurrencies();

}
