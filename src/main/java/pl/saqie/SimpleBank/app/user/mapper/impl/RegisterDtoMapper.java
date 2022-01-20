package pl.saqie.SimpleBank.app.user.mapper.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.config.security.PasswordEncoder;
import pl.saqie.SimpleBank.app.user.mapper.UserMapperToEntity;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user_information.mapper.UserInformationMapperToEntity;
import pl.saqie.SimpleBank.app.utils.BasicDto;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RegisterDtoMapper implements UserMapperToEntity {

    private final UserInformationMapperToEntity mapperToEntity;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapDtoToEntity(BasicDto basicDto) {
        RegisterDto dto = (RegisterDto) basicDto;
        return User.builder()
                .pesel(dto.getPesel())
                .createdDate(LocalDate.now())
                .password(passwordEncoder.getPasswordEncoder().encode(dto.getPassword()))
                .email(dto.getEmail())
                .userInformation(mapperToEntity.mapDtoToEntity(dto))
                .build();
    }
}
