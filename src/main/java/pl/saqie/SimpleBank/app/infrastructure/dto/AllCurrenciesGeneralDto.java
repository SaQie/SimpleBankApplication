package pl.saqie.SimpleBank.app.infrastructure.dto;

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
