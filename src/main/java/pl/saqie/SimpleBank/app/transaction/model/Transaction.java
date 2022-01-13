package pl.saqie.SimpleBank.app.transaction.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String targetAccountNumber;
    private String description;
    private LocalDateTime createdDate;
    private BigDecimal value;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
}
