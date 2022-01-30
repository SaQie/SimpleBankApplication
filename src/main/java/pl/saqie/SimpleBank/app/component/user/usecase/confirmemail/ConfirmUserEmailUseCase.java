package pl.saqie.SimpleBank.app.component.user.usecase.confirmemail;

import pl.saqie.SimpleBank.app.common.exceptions.user.TokenNotFoundException;

public interface ConfirmUserEmailUseCase {

    void confirmEmail(String token) throws TokenNotFoundException;

}
