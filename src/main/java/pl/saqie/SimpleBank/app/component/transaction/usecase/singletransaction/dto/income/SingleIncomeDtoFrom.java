package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleIncomeDtoFrom {

    private String firstName;
    private String lastName;
    private String adress;
    private String postalCode;
    private String city;
    private String bankAccountNumber;

}
