package pl.saqie.SimpleBank.app.user.service.validator;

import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;

public interface RegisterValidator {

    void validate(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException;

}
