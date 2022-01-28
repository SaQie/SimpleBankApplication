package pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.component.user.User;

public interface AllIncomesUseCase {

    Page<IncomesDto> findAllIncomes(User user, int page);

}
