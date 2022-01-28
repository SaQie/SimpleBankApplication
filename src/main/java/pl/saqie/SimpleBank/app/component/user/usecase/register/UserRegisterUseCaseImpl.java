package pl.saqie.SimpleBank.app.component.user.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.createbankaccount.BankAccountCreateUseCase;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.user.usecase.register.mapper.UserMapperToEntity;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.UserRepository;
import pl.saqie.SimpleBank.app.component.user.usecase.register.validator.RegisterValidator;

import java.util.List;

@AllArgsConstructor
@Service
public class UserRegisterUseCaseImpl implements UserRegisterUseCase {

    private final UserRepository repository;
    private final List<RegisterValidator> validator;
    private final UserMapperToEntity mapperToEntity;
    private final BankAccountCreateUseCase accountService;



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
