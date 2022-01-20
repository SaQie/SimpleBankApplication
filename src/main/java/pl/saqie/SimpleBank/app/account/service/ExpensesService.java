package pl.saqie.SimpleBank.app.account.service;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.account.model.dto.ExpenseDto;
import pl.saqie.SimpleBank.app.user.model.User;


public interface ExpensesService {

    Page<ExpenseDto> findAllExpenses(User user, int page);

}
