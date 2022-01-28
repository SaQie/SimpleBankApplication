package pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.transaction.TransactionRepository;
import pl.saqie.SimpleBank.app.component.user.User;

@Service
@AllArgsConstructor
public class AllIncomesUseCaseImpl implements AllIncomesUseCase {

    private final TransactionRepository repository;

    @Override
    public Page<IncomesDto> findAllIncomes(User user, int page) {
        Pageable pageable = PageRequest.of(page -1, 8);
        return repository.customFindIncomesByDate(user.getBankAccount(), pageable);
    }
}
