package pl.saqie.SimpleBank.app.component.user.usecase.register.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

@AllArgsConstructor
@Component
public class UserExistsByPeselChain implements RegisterValidator {

    private final UserRepository userRepository;

    @Override
    public void validate(RegisterDto registerDto) throws UserAlreadyExistsException {
        boolean userExistsByPesel = userRepository.existsByPesel(registerDto.getPesel());
        if (userExistsByPesel){
            throw new UserAlreadyExistsException("Taki numer pesel już istnieje.");
        }
    }
}
