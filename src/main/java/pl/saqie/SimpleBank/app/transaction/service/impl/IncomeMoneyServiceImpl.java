package pl.saqie.SimpleBank.app.transaction.service.impl;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.transaction.service.IncomeMoneyService;

import java.math.BigDecimal;

@Service
public class IncomeMoneyServiceImpl implements IncomeMoneyService {

    @Override
    public void addMoney(BankAccount account, BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().add(amount));
        account.setAllIncomes(account.getAllIncomes().add(amount));
    }
}
