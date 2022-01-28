package pl.saqie.SimpleBank.app.transaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.transaction.exception.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.transaction.mapper.TransactionMapperToDto;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.transaction.service.SingleExpenseService;
import pl.saqie.SimpleBank.app.user.model.User;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SingleExpenseServiceImpl implements SingleExpenseService {

    private final TransactionRepository repository;
    private final TransactionMapperToDto mapper;


    @Override
    public SingleExpenseDto getSingleExpenseById(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = checkTransactionIsEqualsToUser(id, user);
        return mapToDto(transaction);
    }

    private SingleExpenseDto mapToDto(Transaction transaction) {
        return mapper.mapToDto(transaction);
    }

    private Transaction checkTransactionIsEqualsToUser(Long id, User user) throws TransactionNotFoundException {
        Transaction transaction = repository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transakcja nie została odnaleziona."));
        if (!Objects.equals(transaction.getAccountFrom().getUser().getId(), user.getId())) {
            throw new TransactionNotFoundException("Transakcja nie została odnaleziona.");
        }
        return transaction;
    }
}
