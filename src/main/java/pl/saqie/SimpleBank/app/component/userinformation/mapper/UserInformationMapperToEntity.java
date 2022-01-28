package pl.saqie.SimpleBank.app.component.userinformation.mapper;

import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;
import pl.saqie.SimpleBank.app.component.userinformation.UserInformation;

public interface UserInformationMapperToEntity {

    UserInformation mapDtoToEntity(RegisterDto registerDto);

}
