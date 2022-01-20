package pl.saqie.SimpleBank.app.account.service.validator;

import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.math.BigDecimal;

public interface TransferMoneyValidatorChain {

    void chain(BankAccount bankAccount, BigDecimal amount, BankAccount toBackAccount) throws NotEnoughMoneyException, SameAccountException;

}
