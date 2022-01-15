package pl.saqie.SimpleBank.app.user_information.mapper;

import pl.saqie.SimpleBank.app.user.model.dto.UserGenericDto;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;

public interface UserInformationMapperToDto {

    UserGenericDto mapEntityToDto(UserInformation userInformation);

}
