package pl.saqie.SimpleBank.app.component.transaction.usecase.moneyincome;

import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

public interface MoneyIncomeUseCase {

    void addMoney(BankAccount account, BigDecimal amount);

}
