package pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients;

import org.springframework.data.domain.Page;
import pl.saqie.SimpleBank.app.component.user.User;

public interface AllRecipientsUseCase {

    Page<AllRecipientsDto> findAllRecipients(User user, int page);

}
