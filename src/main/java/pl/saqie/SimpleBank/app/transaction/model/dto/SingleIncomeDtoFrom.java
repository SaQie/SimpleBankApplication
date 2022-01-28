package pl.saqie.SimpleBank.app.transaction.model.dto;

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
