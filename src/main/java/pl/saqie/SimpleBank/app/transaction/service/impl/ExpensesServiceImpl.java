package pl.saqie.SimpleBank.app.transaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.transaction.model.dto.ExpensesDto;
import pl.saqie.SimpleBank.app.transaction.service.ExpensesService;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.user.model.User;

@Service
@AllArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {

    private final TransactionRepository repository;

    @Override
    public Page<ExpensesDto> findAllExpenses(User user, int page) {
        Pageable pageable = PageRequest.of(page -1, 8);
        return repository.customFindExpensesByDate(user.getBankAccount(), pageable);
    }
}
