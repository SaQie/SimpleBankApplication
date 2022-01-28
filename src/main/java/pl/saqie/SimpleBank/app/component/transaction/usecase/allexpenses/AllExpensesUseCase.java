package pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.component.user.User;


public interface AllExpensesUseCase {

    Page<ExpensesDto> findAllExpenses(User user, int page);

}
