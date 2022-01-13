package pl.saqie.SimpleBank.app.user_information.mapper;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.model.dto.UserGenericDto;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;

@Service
public class RegisterUserInformationMapper implements UserInformationMapper{

    @Override
    public UserInformation mapDtoToEntity(UserGenericDto genericDto) {
        RegisterDto dto = (RegisterDto) genericDto;
        return UserInformation.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .adress(dto.getAdress())
                .gender(dto.getGender())
                .postalCode(dto.getPostalCode())
                .telephoneNumber(dto.getTelephoneNumber())
                .build();
    }

    @Override
    public UserGenericDto mapEntityToDto(UserInformation userInformation) {
        return null;
    }
}
