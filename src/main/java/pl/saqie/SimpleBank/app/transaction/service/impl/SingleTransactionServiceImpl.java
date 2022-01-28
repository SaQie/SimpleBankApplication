package pl.saqie.SimpleBank.app.transaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.transaction.exception.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.transaction.mapper.TransactionMapperToDto;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleIncomeDto;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.transaction.service.SingleTransactionService;
import pl.saqie.SimpleBank.app.user.model.User;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SingleTransactionServiceImpl implements SingleTransactionService {

    private final TransactionRepository repository;
    private final TransactionMapperToDto mapper;


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
