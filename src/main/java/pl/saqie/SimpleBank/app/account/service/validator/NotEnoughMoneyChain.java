package pl.saqie.SimpleBank.app.account.service.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.math.BigDecimal;

@Component
public class NotEnoughMoneyChain implements TransferMoneyValidatorChain{

    @Override
    public void chain(BankAccount fromBankAccount, BigDecimal amount, BankAccount toBankAccount) throws NotEnoughMoneyException {
        if (fromBankAccount.getAccountBalance().compareTo(amount) < 0){
            throw new NotEnoughMoneyException("Nie posiadasz wystarczającej ilości środków na koncie aby to wykonać.");
        }
    }
}