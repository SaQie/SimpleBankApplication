package pl.saqie.SimpleBank.app.component.bankaccount;

import lombok.*;
import pl.saqie.SimpleBank.app.component.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private User user;

    private String accountNumber;
    private BigDecimal accountBalance;
    private LocalDate accountCreatedDate;
    private int accountNumberOfRecipients;
    private int accountNumberOfExpenses;
    private BigDecimal allIncomes;
    private BigDecimal allExpenses;
}
