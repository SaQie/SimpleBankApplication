package pl.saqie.SimpleBank.app.component.user.usecase.register.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.config.security.PasswordEncoder;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;
import pl.saqie.SimpleBank.app.component.userinformation.mapper.UserInformationMapperToEntity;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RegisterDtoMapper implements UserMapperToEntity {

    private final UserInformationMapperToEntity mapperToEntity;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapDtoToEntity(RegisterDto registerDto) {
        return User.builder()
                .pesel(registerDto.getPesel())
                .createdDate(LocalDate.now())
                .password(passwordEncoder.getPasswordEncoder().encode(registerDto.getPassword()))
                .email(registerDto.getEmail())
                .userInformation(mapperToEntity.mapDtoToEntity(registerDto))
                .build();
    }
}
