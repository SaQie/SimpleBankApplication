package pl.saqie.SimpleBank.app.component.user.usecase.register;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.saqie.SimpleBank.app.component.user.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto{

    @PESEL(message = "Wprowadz poprawny numer PESEL")
    private String pesel;
    @NotEmpty(message = "Wprowadz swoje imię")
    private String firstName;
    @NotEmpty(message = "Wprowadz nazwisko")
    private String lastName;
    @NotEmpty(message = "Musisz podać swój adres zamieszkania")
    private String adress;
    @NotEmpty(message = "Wprowadz kod pocztowy")
    private String postalCode;
    @NotEmpty(message = "Wporwadz swój adres zamieszkania")
    private String city;
    @NotEmpty(message = "Adres email nie może być pusty.")
    @Email(message = "Adres E-mail nie jest poprawny")
    private String email;
    @Size(min = 4, max = 30, message = "Hasło powinno zawierać co najmniej 4 znaki")
    private String password;
    private String passwordRepeat;
    @NotNull(message = "Wybierz swoją płeć")
    private Gender gender;
    private String telephoneNumber;
}
