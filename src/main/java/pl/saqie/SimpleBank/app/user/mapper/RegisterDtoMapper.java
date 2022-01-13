package pl.saqie.SimpleBank.app.user.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.model.dto.UserGenericDto;
import pl.saqie.SimpleBank.app.user_information.mapper.UserInformationMapper;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class RegisterDtoMapper implements UserMapper{

    private UserInformationMapper mapper;

    @Override
    public User mapDtoToEntity(UserGenericDto genericDto) {
        RegisterDto dto = (RegisterDto) genericDto;
        return User.builder()
                .pesel(dto.getPesel())
                .createdDate(LocalDate.now())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .userInformation(mapper.mapDtoToEntity(dto))
                .build();
    }

    @Override
    public UserGenericDto mapEntityToDto(User user) {
        return RegisterDto.builder().build();
    }
}
