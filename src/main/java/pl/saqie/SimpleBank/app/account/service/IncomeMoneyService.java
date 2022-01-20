package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.math.BigDecimal;

public interface IncomeMoneyService {

    void addMoney(BankAccount account, BigDecimal amount);

}
