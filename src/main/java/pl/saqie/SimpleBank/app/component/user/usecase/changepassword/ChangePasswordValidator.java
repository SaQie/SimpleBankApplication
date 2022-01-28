package pl.saqie.SimpleBank.app.component.user.usecase.changepassword;

import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;

public interface ChangePasswordValidator {

    void valid(String oldPassword, String encodedOldPassword) throws UserIncompatibilePasswordsException;

}
