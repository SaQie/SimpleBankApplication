package pl.saqie.SimpleBank.app.user.mapper;

import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.utils.BasicDto;

public interface UserMapperToEntity {

    User mapDtoToEntity(BasicDto dto);

}
