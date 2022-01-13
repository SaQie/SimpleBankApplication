package pl.saqie.SimpleBank.app.user.service.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;

@Component
public class UserTelephoneNumberCorrectChain implements RegisterValidator{

    @Override
    public void validate(RegisterDto registerDto) throws UserFieldValidationFailedException {
        String telephoneNumber = registerDto.getTelephoneNumber();
        boolean telephoneNumberCorrect = telephoneNumber.matches("^\\d{9}$");
        if (!telephoneNumberCorrect){
            throw new UserFieldValidationFailedException("Numer telefonu nie jest poprawny.");
        }
    }
}
