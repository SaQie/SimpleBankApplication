package pl.saqie.SimpleBank.app.transaction.model;

import lombok.*;
import pl.saqie.SimpleBank.app.account.model.BankAccount;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime createdDate;
    private BigDecimal value;

    @ManyToOne
    private BankAccount accountFrom;
    @ManyToOne
    private BankAccount accountTo;
}
