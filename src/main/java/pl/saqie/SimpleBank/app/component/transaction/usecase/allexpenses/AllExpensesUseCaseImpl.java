package pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.transaction.TransactionRepository;
import pl.saqie.SimpleBank.app.component.user.User;

@Service
@AllArgsConstructor
public class AllExpensesUseCaseImpl implements AllExpensesUseCase {

    private final TransactionRepository repository;

    @Override
    public Page<ExpensesDto> findAllExpenses(User user, int page) {
        Pageable pageable = PageRequest.of(page -1, 8);
        return repository.customFindExpensesByDate(user.getBankAccount(), pageable);
    }
}
