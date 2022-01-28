package pl.saqie.SimpleBank.app.component.user.usecase.changepassword;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.config.security.PasswordEncoder;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;

@Component
@AllArgsConstructor
public class ChangePasswordValidatorImpl implements ChangePasswordValidator {

    private final PasswordEncoder passwordEncoder;

    @Override
    public void valid(String oldPassword, String encodedOldPassword) throws UserIncompatibilePasswordsException {
        BCryptPasswordEncoder passwordEncoder = this.passwordEncoder.getPasswordEncoder();
        boolean passwordMatches = passwordEncoder.matches(oldPassword, encodedOldPassword);
        if (!passwordMatches){
            throw new UserIncompatibilePasswordsException("Aktualne hasło nie jest poprawne.");
        }
    }
}
