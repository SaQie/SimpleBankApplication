package pl.saqie.SimpleBank.app.component.user.usecase.changepassword;

import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.User;

public interface ChangePasswordUseCase {

    void changePassword(ChangePasswordDto changePasswordDto, User user) throws UserIncompatibilePasswordsException;

}
