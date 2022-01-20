package pl.saqie.SimpleBank.app.transaction.service;

import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.math.BigDecimal;

public interface TransactionService {

    void saveTransaction(BankAccount from, BankAccount to, String description, BigDecimal value);

}
