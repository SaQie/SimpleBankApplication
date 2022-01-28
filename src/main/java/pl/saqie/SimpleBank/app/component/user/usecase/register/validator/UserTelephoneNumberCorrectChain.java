package pl.saqie.SimpleBank.app.component.user.usecase.register.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;

@Component
public class UserTelephoneNumberCorrectChain implements RegisterValidator {

    @Override
    public void validate(RegisterDto registerDto) throws UserFieldValidationFailedException {
        String telephoneNumber = registerDto.getTelephoneNumber();
        boolean telephoneNumberCorrect = telephoneNumber.matches("^\\d{9}$");
        if (!telephoneNumberCorrect){
            throw new UserFieldValidationFailedException("Numer telefonu nie jest poprawny.");
        }
    }
}
