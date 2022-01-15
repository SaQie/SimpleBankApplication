package pl.saqie.SimpleBank.app.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.service.BankAccountCreateService;
import pl.saqie.SimpleBank.app.user.exception.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.user.exception.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.user.exception.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.user.mapper.UserMapperToEntity;
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
    private final UserMapperToEntity mapperToEntity;
    private final BankAccountCreateService accountService;



    @Override
    public void registerUser(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException {
        validateRegisterDto(registerDto);
        User user = mapperToEntity.mapDtoToEntity(registerDto);
        assignBankAccountToUser(user);
        repository.save(user);
    }

    private void validateRegisterDto(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException {
        for (RegisterValidator validator : validator) {
            validator.validate(registerDto);
        }
    }

    private void assignBankAccountToUser(User user){
        BankAccount bankAccount = accountService.createNewBankAccount(user);
        user.setBankAccount(bankAccount);
    }
}
