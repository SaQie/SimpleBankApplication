package pl.saqie.SimpleBank.app.component.transaction.usecase.createtransaction;

import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

public interface CreateTransactionUseCase {

    void saveTransaction(BankAccount from, BankAccount to, String description, BigDecimal value);

}
