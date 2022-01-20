package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.math.BigDecimal;

public interface WithdrawalMoneyService {

    void withdrawalMoney(BankAccount account, BigDecimal amount);

}
