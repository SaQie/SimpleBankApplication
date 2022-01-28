package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.validator;

import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;

import java.math.BigDecimal;

@Component
public class SameAccountChain implements TransferMoneyValidatorChain {

    @Override
    public void chain(BankAccount bankAccount, BigDecimal amount, BankAccount toBackAccount) throws SameAccountException {
        if (bankAccount.getId() == toBackAccount.getId()){
            throw new SameAccountException("Nie możesz wysłać przelewu do samego siebie.");
        }
    }
}
