package pl.saqie.SimpleBank.app.component.userinformation.mapper;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;
import pl.saqie.SimpleBank.app.component.userinformation.UserInformation;

@Service
public class UserInformationMapperToEntityImpl implements UserInformationMapperToEntity {

    @Override
    public UserInformation mapDtoToEntity(RegisterDto dto) {
        return UserInformation.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .adress(dto.getAdress())
                .city(dto.getCity())
                .gender(dto.getGender())
                .postalCode(dto.getPostalCode())
                .telephoneNumber(dto.getTelephoneNumber())
                .build();
    }
}
