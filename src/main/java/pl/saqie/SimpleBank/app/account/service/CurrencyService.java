package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.exception.CurrencyNotFoundException;
import pl.saqie.SimpleBank.app.infrastructure.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.infrastructure.dto.SingleCurrencyGeneralDto;

public interface CurrencyService {

    SingleCurrencyGeneralDto getSingleCurrency(String code) throws CurrencyNotFoundException;
    AllCurrenciesGeneralDto[] getAllCurrencies();

}
