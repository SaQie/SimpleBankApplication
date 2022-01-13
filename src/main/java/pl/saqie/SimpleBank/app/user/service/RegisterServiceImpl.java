package pl.saqie.SimpleBank.app.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.mapper.UserMapper;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user.model.dto.RegisterDto;
import pl.saqie.SimpleBank.app.user.repository.UserRepository;
import pl.saqie.SimpleBank.app.user.service.validator.RegisterValidator;

import java.util.List;

@AllArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{

    private final UserRepository repository;
    private final List<RegisterValidator> validator;
    private final UserMapper mapper;



    @Override
    public void addNewUser(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException {
        for (RegisterValidator validator : validator) {
            validator.validate(registerDto);
        }
        User user = mapper.mapDtoToEntity(registerDto);
        repository.save(user);
    }
}
