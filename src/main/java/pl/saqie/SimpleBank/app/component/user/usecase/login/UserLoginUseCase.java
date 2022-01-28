package pl.saqie.SimpleBank.app.component.user.usecase.login;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

@Service
@AllArgsConstructor
public class UserLoginUseCase implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        return userRepository.findByPesel(pesel).orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika."));
    }
}
