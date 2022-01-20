package pl.saqie.SimpleBank.app.user_information.mapper;

import pl.saqie.SimpleBank.app.user_information.model.UserInformation;
import pl.saqie.SimpleBank.app.utils.BasicDto;

public interface UserInformationMapperToEntity {

    UserInformation mapDtoToEntity(BasicDto dto);

}
