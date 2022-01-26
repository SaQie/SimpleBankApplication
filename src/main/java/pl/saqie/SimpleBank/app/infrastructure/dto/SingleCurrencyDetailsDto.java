package pl.saqie.SimpleBank.app.infrastructure.dto;

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
