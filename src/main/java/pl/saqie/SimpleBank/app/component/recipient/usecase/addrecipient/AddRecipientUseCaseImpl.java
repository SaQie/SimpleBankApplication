package pl.saqie.SimpleBank.app.component.recipient.usecase.addrecipient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.exceptions.recipient.RecipientAlreadyExistsException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccountRepository;
import pl.saqie.SimpleBank.app.component.recipient.Recipient;
import pl.saqie.SimpleBank.app.component.recipient.RecipientRepository;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddRecipientUseCaseImpl implements AddRecipientUseCase{

    private final RecipientRepository recipientRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public void addNewRecipient(RecipientDto recipientDto, User user) throws RecipientAlreadyExistsException, AccountNotFoundException, SameAccountException {
        Optional<List<Recipient>> userRecipientList = recipientRepository.findAllByUserId(user.getId());
        checkIsThisSameAccount(recipientDto, user);
        if(userRecipientList.isPresent()) {
            List<Recipient> recipientList = userRecipientList.get();
            if (checkBankAccountAlreadyExistsInRecipients(recipientList, recipientDto)) {
                saveNewRecipient(recipientDto, user);
            }
        }else {
            saveNewRecipient(recipientDto, user);
        }
        saveBankAccountRecipientsCount(user);
    }

    private void saveBankAccountRecipientsCount(User user) {
        BankAccount bankAccount = user.getBankAccount();
        bankAccount.setAccountNumberOfRecipients(bankAccount.getAccountNumberOfRecipients() + 1);
        bankAccountRepository.save(bankAccount);
    }

    private void checkIsThisSameAccount(RecipientDto recipientDto, User user) throws SameAccountException {
        String accountNumber = user.getBankAccount().getAccountNumber();
        if (recipientDto.getBankAccountNumber().equals(accountNumber)){
            throw new SameAccountException("Nie możesz dodać swojego konta do listy odbiorców.");
        }
    }

    private void saveNewRecipient(RecipientDto recipientDto, User user) throws AccountNotFoundException {
        BankAccount bankAccount = checkBankAccountExistsInDb(recipientDto);
        Recipient recipient = new Recipient(LocalDate.now(), user ,bankAccount);
        recipientRepository.save(recipient);
    }

    private BankAccount checkBankAccountExistsInDb(RecipientDto recipientDto) throws AccountNotFoundException {
        Optional<BankAccount> accountOptional = bankAccountRepository.findByAccountNumber(recipientDto.getBankAccountNumber());
        if (accountOptional.isPresent()){
            return accountOptional.get();
        }
        throw new AccountNotFoundException("Nie znaleziono konta bankowego o podanym numerze.");
    }

    private boolean checkBankAccountAlreadyExistsInRecipients(List<Recipient> byUserId, RecipientDto recipientDto) throws RecipientAlreadyExistsException {
        String accountNumber;
        for (Recipient recipient : byUserId){
            accountNumber = recipient.getBankAccount().getAccountNumber();
            if(accountNumber.equals(recipientDto.getBankAccountNumber())){
                throw new RecipientAlreadyExistsException("Taki odbiorca już istnieje w Twojej liście.");
            }
        }
        return true;
    }
}
