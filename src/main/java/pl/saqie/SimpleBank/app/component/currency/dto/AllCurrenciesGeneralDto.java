package pl.saqie.SimpleBank.app.component.currency.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllCurrenciesGeneralDto{

    private String effectiveDate;
    private List<AllCurrenciesDetailsDto> rates;

}
