package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleExpenseDtoTo {

    private String firstName;
    private String lastName;
    private String adress;
    private String postalCode;
    private String city;
    private String bankAccountNumber;

}
