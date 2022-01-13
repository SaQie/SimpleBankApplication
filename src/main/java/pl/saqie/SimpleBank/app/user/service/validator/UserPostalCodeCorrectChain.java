package pl.saqie.SimpleBank.app.user.service.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;

@Component
public class UserPostalCodeCorrectChain implements RegisterValidator{

    @Override
    public void validate(RegisterDto registerDto) throws UserFieldValidationFailedException {
        String postalCode = registerDto.getPostalCode();
        boolean postalCodeCorrect = postalCode.matches("^[0-9]{2}-[0-9]{3}$");
        if (!postalCodeCorrect){
            throw new UserFieldValidationFailedException("Kod pocztowy nie jest poprawny.");
        }
    }
}
