package pl.saqie.SimpleBank.app.component.user.usecase.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.createbankaccount.BankAccountCreateUseCase;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserFieldValidationFailedException;
import pl.saqie.SimpleBank.app.common.exceptions.user.UserIncompatibilePasswordsException;
import pl.saqie.SimpleBank.app.component.emailsender.EmailSender;
import pl.saqie.SimpleBank.app.component.user.usecase.register.mapper.UserMapperToEntity;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.UserRepository;
import pl.saqie.SimpleBank.app.component.user.usecase.register.validator.RegisterValidator;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserRegisterUseCaseImpl implements UserRegisterUseCase {

    private final UserRepository repository;
    private final List<RegisterValidator> validator;
    private final UserMapperToEntity mapperToEntity;
    private final BankAccountCreateUseCase accountService;
    private final EmailSender emailSender;


    @Override
    public void registerUser(RegisterDto registerDto) throws UserAlreadyExistsException, UserIncompatibilePasswordsException, UserFieldValidationFailedException, MessagingException, UnsupportedEncodingException {
        validateRegisterDto(registerDto);
        User user = mapperToEntity.mapDtoToEntity(registerDto);
        assignBankAccountToUser(user);
        String acicationToken = assignActivationTokenToUser(user);
        emailSender.sendRegisterEmail(user.getEmail(), acicationToken);
        repository.save(user);
    }

    private String assignActivationTokenToUser(User user) {
        String token = UUID.randomUUID().toString();
        user.setEmailActivationToken(token);
        return token;
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
