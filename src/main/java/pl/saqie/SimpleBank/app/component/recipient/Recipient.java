package pl.saqie.SimpleBank.app.component.recipient;

import lombok.*;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate addedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private BankAccount bankAccount;

    public Recipient(LocalDate addedDate, User user, BankAccount bankAccount) {
        this.user = user;
        this.addedDate = addedDate;
        this.bankAccount = bankAccount;
    }
}
