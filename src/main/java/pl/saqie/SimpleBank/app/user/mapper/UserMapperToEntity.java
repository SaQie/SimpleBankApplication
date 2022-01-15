package pl.saqie.SimpleBank.app.user.mapper;

import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.UserGenericDto;

public interface UserMapperToEntity {

    User mapDtoToEntity(UserGenericDto dto);

}
