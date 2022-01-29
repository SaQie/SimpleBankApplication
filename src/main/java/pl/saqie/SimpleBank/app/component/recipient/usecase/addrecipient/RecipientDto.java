package pl.saqie.SimpleBank.app.component.recipient.usecase.addrecipient;

import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipientDto {

    @Size(min = 26, max = 26, message = "Wprowadz poprawny numer konta bankowego.")
    private String bankAccountNumber;

}
