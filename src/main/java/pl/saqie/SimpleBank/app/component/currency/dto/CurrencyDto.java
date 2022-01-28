package pl.saqie.SimpleBank.app.component.currency.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto {
    @NotEmpty(message = "Kod waluty nie może być pusty")
    private String code;
}
