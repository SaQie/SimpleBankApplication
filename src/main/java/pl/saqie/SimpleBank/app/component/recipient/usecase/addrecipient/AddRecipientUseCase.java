package pl.saqie.SimpleBank.app.component.recipient.usecase.addrecipient;

import pl.saqie.SimpleBank.app.common.exceptions.recipient.RecipientAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.user.User;

public interface AddRecipientUseCase {

    void addNewRecipient(RecipientDto recipientDto, User user) throws RecipientAlreadyExistsException, AccountNotFoundException, SameAccountException;

}
