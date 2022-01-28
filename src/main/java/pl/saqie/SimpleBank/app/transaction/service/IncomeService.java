package pl.saqie.SimpleBank.app.transaction.service;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.transaction.model.dto.IncomesDto;
import pl.saqie.SimpleBank.app.user.model.User;

public interface IncomeService {

    Page<IncomesDto> findAllIncomes(User user, int page);

}
