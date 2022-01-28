package pl.saqie.SimpleBank.app.component.user.usecase.changepassword;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.config.security.PasswordEncoder;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

@Service
@AllArgsConstructor
public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {

    private final ChangePasswordValidator validator;
    private final PasswordEncoder encoder;
    private final UserRepository repository;

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto, User user) throws UserIncompatibilePasswordsException {
        String currentPassword = user.getPassword();
        validator.valid(changePasswordDto.getOldPassword(),currentPassword);
        String newPassword = encodeNewPassword(changePasswordDto.getNewPassword());
        user.setPassword(newPassword);
        repository.save(user);
    }

    private String encodeNewPassword(String newPassword) {
        return encoder.getPasswordEncoder().encode(newPassword);
    }
}
