package pl.saqie.SimpleBank.app.component.transaction.usecase.createtransaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.transaction.Transaction;
import pl.saqie.SimpleBank.app.component.transaction.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {

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
