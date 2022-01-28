package pl.saqie.SimpleBank.app.component.transaction.usecase.moneyexpense;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

@Service
public class MoneyExpenseUseCaseImpl implements MoneyExpenseUseCase {

    @Override
    public void withdrawalMoney(BankAccount account, BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().subtract(amount));
        account.setAllExpenses(account.getAllExpenses().add(amount));
        account.setAccountNumberOfExpenses(account.getAccountNumberOfExpenses() + 1);
    }
}
