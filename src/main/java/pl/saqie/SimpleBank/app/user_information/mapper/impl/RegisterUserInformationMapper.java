package pl.saqie.SimpleBank.app.user_information.mapper.impl;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user_information.mapper.UserInformationMapperToEntity;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;
import pl.saqie.SimpleBank.app.utils.BasicDto;

@Service
public class RegisterUserInformationMapper implements UserInformationMapperToEntity {

    @Override
    public UserInformation mapDtoToEntity(BasicDto basicDto) {
        RegisterDto dto = (RegisterDto) basicDto;
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