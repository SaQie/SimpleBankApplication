package pl.saqie.SimpleBank.app.user.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserLoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        return userRepository.findByPesel(pesel).orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono użytkownika."));
    }
}
