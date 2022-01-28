package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.InvalidValueException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

@Component
public class ValueZeroChain implements TransferMoneyValidatorChain {

    @Override
    public void chain(BankAccount bankAccount, BigDecimal amount, BankAccount toBackAccount) throws NotEnoughMoneyException, SameAccountException, InvalidValueException {
        if (amount.signum() <= 0){
            throw new InvalidValueException("Wartość przelewu nie może być równa 0 bądz ujemna.");
        }
    }
}
