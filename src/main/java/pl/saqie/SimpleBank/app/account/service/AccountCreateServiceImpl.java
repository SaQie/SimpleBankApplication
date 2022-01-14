package pl.saqie.SimpleBank.app.account.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.Account;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.utils.AccountNumberGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Service
public class AccountCreateServiceImpl implements AccountCreateService {

    private final AccountNumberGenerator accountNumberGenerator;

    @Override
    public Account createNewAccount(User user) {
        return buildNewAccount(user);
    }

    private Account buildNewAccount(User user) {
        return Account.builder()
                .user(user)
                .accountBalance(BigDecimal.ZERO)
                .accountCreatedDate(LocalDate.now())
                .accountNumber(accountNumberGenerator.createAccountNumber())
                .build();
    }
}
