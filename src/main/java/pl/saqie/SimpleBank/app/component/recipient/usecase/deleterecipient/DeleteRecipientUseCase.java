package pl.saqie.SimpleBank.app.component.recipient.usecase.deleterecipient;

import pl.saqie.SimpleBank.app.component.user.User;

public interface DeleteRecipientUseCase {

    void deleteRecipientById(Long id, User user);

}
