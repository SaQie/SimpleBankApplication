package pl.saqie.SimpleBank.app.component.transaction.usecase.moneyexpense;

import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

public interface MoneyExpenseUseCase {

    void withdrawalMoney(BankAccount account, BigDecimal amount);

}
