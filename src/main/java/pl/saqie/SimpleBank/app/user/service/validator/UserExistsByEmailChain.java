package pl.saqie.SimpleBank.app.user.service.validator;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.repository.UserRepository;

@AllArgsConstructor
@Component
public class UserExistsByEmailChain implements RegisterValidator{

    private final UserRepository userRepository;

    @Override
    public void validate(RegisterDto registerDto) throws UserAlreadyExistsException {
        boolean existsByEmail = userRepository.existsByEmail(registerDto.getEmail());
        if (existsByEmail){
            throw new UserAlreadyExistsException("Taki adres e-mail już istnieje.");
        }
    }
}
