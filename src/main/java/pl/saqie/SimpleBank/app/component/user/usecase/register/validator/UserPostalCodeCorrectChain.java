package pl.saqie.SimpleBank.app.component.user.usecase.register.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;

@Component
public class UserPostalCodeCorrectChain implements RegisterValidator {

    @Override
    public void validate(RegisterDto registerDto) throws UserFieldValidationFailedException {
        String postalCode = registerDto.getPostalCode();
        boolean postalCodeCorrect = postalCode.matches("^[0-9]{2}-[0-9]{3}$");
        if (!postalCodeCorrect){
            throw new UserFieldValidationFailedException("Kod pocztowy nie jest poprawny.");
        }
    }
}
