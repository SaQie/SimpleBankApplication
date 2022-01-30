package pl.saqie.SimpleBank.app.component.user.usecase.confirmemail;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.exceptions.user.TokenNotFoundException;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

@Service
@AllArgsConstructor
public class ConfirmUserEmailUseCaseImpl implements ConfirmUserEmailUseCase{

    private final UserRepository userRepository;

    @Override
    public void confirmEmail(String token) throws TokenNotFoundException {
        User user = checkTokenCorrect(token);
        user.setEmailActivationToken(null);
        user.setEnabled(true);
        userRepository.save(user);
    }

    private User checkTokenCorrect(String token) throws TokenNotFoundException {
       return userRepository.findByEmailActivationToken(token).orElseThrow(() -> new TokenNotFoundException("Token nie został odnaleziony."));
    }
}
