package pl.saqie.SimpleBank.app.component.currency.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleCurrencyGeneralDto{

    private String currency;
    private String code;
    private List<SingleCurrencyDetailsDto> rates;

}
