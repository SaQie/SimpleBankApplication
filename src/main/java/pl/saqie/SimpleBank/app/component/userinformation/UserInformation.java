package pl.saqie.SimpleBank.app.component.userinformation;

import lombok.*;
import pl.saqie.SimpleBank.app.component.user.Gender;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_informations")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String adress;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

}
