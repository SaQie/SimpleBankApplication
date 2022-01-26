package pl.saqie.SimpleBank.app.infrastructure;

import pl.saqie.SimpleBank.app.infrastructure.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.infrastructure.dto.SingleCurrencyGeneralDto;

public interface RestClientService {

    SingleCurrencyGeneralDto callRestClientForSingleCurrency(String code);
    AllCurrenciesGeneralDto[] callRestClientForAllCurrencies();

}
