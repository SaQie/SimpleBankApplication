package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney;

import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.InvalidValueException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.user.User;

import java.text.ParseException;

public interface TransferMoneyUseCase {

    void transfer(User user, TransferMoneyDto dto) throws AccountNotFoundException, ParseException, NotEnoughMoneyException, SameAccountException, InvalidValueException;

}
