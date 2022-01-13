package pl.saqie.SimpleBank.app.account.model;

import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.user.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    private String accountNumber;
    private BigDecimal accountBalance;
    private LocalDate accountCreatedDate;

    @OneToMany
    private List<Transaction> transactions;
}
