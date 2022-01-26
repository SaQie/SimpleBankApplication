package pl.saqie.SimpleBank.app.user.mapper;

import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;

public interface UserMapperToEntity {

    User mapDtoToEntity(RegisterDto dto);

}
