package pl.saqie.SimpleBank.app.component.transaction.usecase.moneyincome;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

@Service
public class MoneyIncomeUseCaseImpl implements MoneyIncomeUseCase {

    @Override
    public void addMoney(BankAccount account, BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().add(amount));
        account.setAllIncomes(account.getAllIncomes().add(amount));
    }
}
