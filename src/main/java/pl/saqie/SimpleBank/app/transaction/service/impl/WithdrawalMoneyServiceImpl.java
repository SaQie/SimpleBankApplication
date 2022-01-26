package pl.saqie.SimpleBank.app.transaction.service.impl;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.transaction.service.WithdrawalMoneyService;

import java.math.BigDecimal;

@Service
public class WithdrawalMoneyServiceImpl implements WithdrawalMoneyService {

    @Override
    public void withdrawalMoney(BankAccount account, BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().subtract(amount));
        account.setAllExpenses(account.getAllExpenses().add(amount));
        account.setAccountNumberOfExpenses(account.getAccountNumberOfExpenses() + 1);
    }
}
