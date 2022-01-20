package pl.saqie.SimpleBank.app.user.mapper;

import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.utils.BasicDto;

public interface UserMapperToDto {

    BasicDto mapEntityToDto(User user);

}
