package pl.saqie.SimpleBank.app.component.user.usecase.accountdata;

import lombok.*;
import pl.saqie.SimpleBank.app.component.user.Gender;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDataDto {

    private String firstName;
    private String lastName;
    private String pesel;
    private String adress;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String email;
    private LocalDate createdDate;
    private String accountNumber;

}
