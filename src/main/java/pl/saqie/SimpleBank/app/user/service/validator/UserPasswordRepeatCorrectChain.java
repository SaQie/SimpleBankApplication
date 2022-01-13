package pl.saqie.SimpleBank.app.user.service.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;

@Component
public class UserPasswordRepeatCorrectChain implements RegisterValidator{

    @Override
    public void validate(RegisterDto registerDto) throws UserIncompatibilePasswordsException {
        boolean passwordEqualsPasswordRepeat = registerDto.getPassword().equals(registerDto.getPasswordRepeat());
        if (!passwordEqualsPasswordRepeat){
            throw new UserIncompatibilePasswordsException("Hasła nie są takie same");
        }
    }
}