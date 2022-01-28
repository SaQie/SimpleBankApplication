package pl.saqie.SimpleBank.app.component.rest.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.currency.dto.AllCurrenciesGeneralDto;
import pl.saqie.SimpleBank.app.component.currency.dto.SingleCurrencyGeneralDto;
import pl.saqie.SimpleBank.app.component.rest.RestClient;
import pl.saqie.SimpleBank.app.component.rest.service.RestClientService;

@Service
@AllArgsConstructor
public class RestClientServiceImpl implements RestClientService {

    private static final String ALL_CURRENCIES_URL = "http://api.nbp.pl/api/exchangerates/tables/C/?format=json";
    private static final String SINGLE_CURRENCY_URL = "http://api.nbp.pl/api/exchangerates/rates/c/{code}/?format=json";

    private final RestClient restTemplate;

    @Override
    public SingleCurrencyGeneralDto callRestClientForSingleCurrency(String code) {
        return restTemplate.restTemplate().getForObject(SINGLE_CURRENCY_URL, SingleCurrencyGeneralDto.class, code);
    }

    @Override
    public AllCurrenciesGeneralDto[] callRestClientForAllCurrencies() {
        return restTemplate.restTemplate().getForObject(ALL_CURRENCIES_URL, AllCurrenciesGeneralDto[].class);
    }
}
