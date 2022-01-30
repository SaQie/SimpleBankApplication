package pl.saqie.SimpleBank.app.component.user.usecase.register;

import pl.saqie.SimpleBank.app.common.exceptions.user.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface UserRegisterUseCase {

    void registerUser(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException, MessagingException, UnsupportedEncodingException;

}
