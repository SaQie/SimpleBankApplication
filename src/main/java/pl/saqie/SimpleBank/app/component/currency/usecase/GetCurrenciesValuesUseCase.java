package pl.saqie.SimpleBank.app.component.currency.usecase;

import pl.saqie.SimpleBank.app.common.exceptions.currency.CurrencyNotFoundException;
import pl.saqie.SimpleBank.app.component.currency.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.component.currency.dto.SingleCurrencyGeneralDto;

public interface GetCurrenciesValuesUseCase {

    SingleCurrencyGeneralDto getSingleCurrency(String code) throws CurrencyNotFoundException;
    AllCurrenciesGeneralDto[] getAllCurrencies();

}
