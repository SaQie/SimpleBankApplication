package pl.saqie.SimpleBank.app.transaction.service;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.transaction.model.dto.ExpensesDto;
import pl.saqie.SimpleBank.app.user.model.User;


public interface ExpensesService {

    Page<ExpensesDto> findAllExpenses(User user, int page);

}
