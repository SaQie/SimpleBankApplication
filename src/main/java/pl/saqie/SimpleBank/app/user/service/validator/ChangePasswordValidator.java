package pl.saqie.SimpleBank.app.user.service.validator;

import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;

public interface ChangePasswordValidator {

    void valid(String oldPassword, String encodedOldPassword) throws UserIncompatibilePasswordsException;

}
