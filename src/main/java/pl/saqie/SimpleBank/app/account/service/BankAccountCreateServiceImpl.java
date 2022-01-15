package pl.saqie.SimpleBank.app.account.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.utils.AccountNumberGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class BankAccountCreateServiceImpl implements BankAccountCreateService {

    private final AccountNumberGenerator accountNumberGenerator;

    @Override
    public BankAccount createNewBankAccount(User user) {
        return buildNewBankAccount(user);
    }

    private BankAccount buildNewBankAccount(User user) {
        return BankAccount.builder()
                .user(user)
                .accountBalance(BigDecimal.ZERO)
                .accountCreatedDate(LocalDate.now())
                .accountNumberOfExpenses(0)
                .accountNumberOfRecipients(0)
                .accountNumber(accountNumberGenerator.createAccountNumber())
                .build();
    }
}
