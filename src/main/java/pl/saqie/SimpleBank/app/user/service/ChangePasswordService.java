package pl.saqie.SimpleBank.app.user.service;

import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.ChangePasswordDto;

public interface ChangePasswordService {

    void changePassword(ChangePasswordDto changePasswordDto, User user) throws UserIncompatibilePasswordsException;

}
