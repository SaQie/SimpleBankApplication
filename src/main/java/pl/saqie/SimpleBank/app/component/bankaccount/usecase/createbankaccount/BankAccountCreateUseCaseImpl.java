package pl.saqie.SimpleBank.app.component.bankaccount.usecase.createbankaccount;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.common.number.AccountNumberGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class BankAccountCreateUseCaseImpl implements BankAccountCreateUseCase {

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
