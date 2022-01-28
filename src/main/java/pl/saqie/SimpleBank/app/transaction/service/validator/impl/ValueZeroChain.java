package pl.saqie.SimpleBank.app.transaction.service.validator.impl;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.account.exception.InvalidValueException;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.transaction.service.validator.TransferMoneyValidatorChain;

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
