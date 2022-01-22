package pl.saqie.SimpleBank.app.user.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.config.security.PasswordEncoder;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.ChangePasswordDto;
import pl.saqie.SimpleBank.app.user.repository.UserRepository;
import pl.saqie.SimpleBank.app.user.service.ChangePasswordService;
import pl.saqie.SimpleBank.app.user.service.validator.ChangePasswordValidator;

@Service
@AllArgsConstructor
public class ChangePasswordServiceImpl implements ChangePasswordService {

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
