package pl.saqie.SimpleBank.app.component.currency.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllCurrenciesDetailsDto {

    private String currency;
    private String code;
    private double bid;
    private double ask;

}
