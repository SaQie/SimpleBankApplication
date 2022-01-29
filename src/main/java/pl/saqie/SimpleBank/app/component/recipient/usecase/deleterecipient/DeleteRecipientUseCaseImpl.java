package pl.saqie.SimpleBank.app.component.recipient.usecase.deleterecipient;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccountRepository;
import pl.saqie.SimpleBank.app.component.recipient.Recipient;
import pl.saqie.SimpleBank.app.component.recipient.RecipientRepository;
import pl.saqie.SimpleBank.app.component.user.User;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DeleteRecipientUseCaseImpl implements DeleteRecipientUseCase{

    private final RecipientRepository recipientRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public void deleteRecipientById(Long id, User user) {
        Optional<Recipient> optionalRecipient = recipientRepository.findById(id);
        if (optionalRecipient.isPresent()){
            Recipient recipient = optionalRecipient.get();
            if (recipient.getUser().getId().equals(user.getId())){
                deleteRecipient(id, user);
            }
        }
    }

    private void deleteRecipient(Long id, User user) {
        recipientRepository.deleteById(id);
        saveUserBankAccountNumberOfRecipients(user);
    }

    private void saveUserBankAccountNumberOfRecipients(User user) {
        BankAccount bankAccount = user.getBankAccount();
        bankAccount.setAccountNumberOfRecipients(bankAccount.getAccountNumberOfRecipients() - 1);
        bankAccountRepository.save(bankAccount);
    }
}
