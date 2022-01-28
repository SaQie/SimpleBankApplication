package pl.saqie.SimpleBank.app.component.currency.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleCurrencyDetailsDto {

    private String effectiveDate;
    private double bid;
    private double ask;

}
