package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney;

import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyDto {

    @Size(min = 26, max = 26, message = "Wprowadz poprawny numer konta")
    private String accountNumber;
    @NotNull(message = "Kwota nie może być 0")
    @NotEmpty(message = "Pole kwota nie może pozostać puste")
    private String amount;
    @Size(max = 15, message = "Opis może się składać z maksymalnie 15 znaków.")
    private String description;
}
