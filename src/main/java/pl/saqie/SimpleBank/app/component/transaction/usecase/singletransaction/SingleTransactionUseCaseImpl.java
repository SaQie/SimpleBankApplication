package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.component.transaction.Transaction;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDto;
import pl.saqie.SimpleBank.app.component.transaction.TransactionRepository;
import pl.saqie.SimpleBank.app.component.user.User;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SingleTransactionUseCaseImpl implements SingleTransactionUseCase {

    private final TransactionRepository repository;
    private final SingleTransactionMapperToDto mapper;


    @Override
    public SingleExpenseDto getSingleExpenseById(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = checkExpenseIsEqualsToUser(id, user);
        return mapper.mapToSingleExpenseDto(transaction);
    }

    @Override
    public SingleIncomeDto getSingleIncomeById(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = checkIncomeIsEqualsToUser(id, user);
        return mapper.mapToSingleIncomeDto(transaction);
    }

    private Transaction checkExpenseIsEqualsToUser(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = checkTransactionExists(id);
        if (!Objects.equals(transaction.getAccountFrom().getUser().getId(), user.getId())) {
            throw new TransactionNotFoundException("Transakcja nie została odnaleziona.");
        }
        return transaction;
    }

    private Transaction checkIncomeIsEqualsToUser(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = checkTransactionExists(id);
        if (!Objects.equals(transaction.getAccountTo().getUser().getId(), user.getId())) {
            throw new TransactionNotFoundException("Transakcja nie została odnaleziona.");
        }
        return transaction;
    }

    private Transaction checkTransactionExists(Long id) throws TransactionNotFoundException {
        return repository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transakcja nie została odnaleziona."));
    }
}
