package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.validator;

import pl.saqie.SimpleBank.app.common.exceptions.transaction.InvalidValueException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

public interface TransferMoneyValidatorChain {

    void chain(BankAccount bankAccount, BigDecimal amount, BankAccount toBackAccount) throws NotEnoughMoneyException, SameAccountException, InvalidValueException;

}
