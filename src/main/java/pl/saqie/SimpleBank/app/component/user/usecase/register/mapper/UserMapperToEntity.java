package pl.saqie.SimpleBank.app.component.user.usecase.register.mapper;

import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.register.RegisterDto;

public interface UserMapperToEntity {

    User mapDtoToEntity(RegisterDto dto);

}
