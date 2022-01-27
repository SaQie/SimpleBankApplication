package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.service.BankAccountCreateService;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.account.service.AccountNumberGenerator;

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
                .accountBalance(BigDecimal.valueOf(50.00))
                .allIncomes(BigDecimal.ZERO)
                .allExpenses(BigDecimal.ZERO)
                .accountNumberOfExpenses(0)
                .accountNumberOfRecipients(0)
                .accountCreatedDate(LocalDate.now())
                .accountNumber(accountNumberGenerator.createAccountNumber())
                .build();
    }
}
