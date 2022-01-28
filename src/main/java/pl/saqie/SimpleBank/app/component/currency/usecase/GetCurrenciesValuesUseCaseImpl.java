package pl.saqie.SimpleBank.app.component.currency.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.exceptions.currency.CurrencyNotFoundException;
import pl.saqie.SimpleBank.app.component.rest.service.RestClientService;
import pl.saqie.SimpleBank.app.component.currency.Currencies;
import pl.saqie.SimpleBank.app.component.currency.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.component.currency.dto.SingleCurrencyGeneralDto;

@Service
@AllArgsConstructor
public class GetCurrenciesValuesUseCaseImpl implements GetCurrenciesValuesUseCase {

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
