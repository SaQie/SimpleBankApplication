package pl.saqie.SimpleBank.app.transaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.transaction.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public void saveTransaction(BankAccount from, BankAccount to, String description, BigDecimal value) {
        Transaction transaction = createTransaction(from,to,description,value);
        repository.save(transaction);
    }

    private Transaction createTransaction(BankAccount from, BankAccount to, String description, BigDecimal value) {
        return Transaction.builder()
                .createdDate(LocalDateTime.now())
                .description(description)
                .accountFrom(from)
                .accountTo(to)
                .value(value)
                .build();
    }
}
