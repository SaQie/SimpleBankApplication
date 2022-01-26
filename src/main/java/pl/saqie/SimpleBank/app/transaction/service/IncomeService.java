package pl.saqie.SimpleBank.app.transaction.service;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.transaction.model.dto.IncomeDto;
import pl.saqie.SimpleBank.app.user.model.User;

public interface IncomeService {

    Page<IncomeDto> findAllIncomes(User user, int page);

}
