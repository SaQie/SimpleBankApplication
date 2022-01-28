package pl.saqie.SimpleBank.app.component.user.usecase.register.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;

@Component
public class UserPasswordRepeatCorrectChain implements RegisterValidator {

    @Override
    public void validate(RegisterDto registerDto) throws UserIncompatibilePasswordsException {
        boolean passwordEqualsPasswordRepeat = registerDto.getPassword().equals(registerDto.getPasswordRepeat());
        if (!passwordEqualsPasswordRepeat){
            throw new UserIncompatibilePasswordsException("Hasła nie są takie same");
        }
    }
}
