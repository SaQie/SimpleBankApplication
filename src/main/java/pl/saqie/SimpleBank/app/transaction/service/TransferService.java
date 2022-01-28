package pl.saqie.SimpleBank.app.transaction.service;

import pl.saqie.SimpleBank.app.account.exception.AccountNotFoundException;
import pl.saqie.SimpleBank.app.account.exception.InvalidValueException;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.transaction.model.dto.TransferDto;
import pl.saqie.SimpleBank.app.user.model.User;

import java.text.ParseException;

public interface TransferService {

    void transfer(User user, TransferDto dto) throws AccountNotFoundException, ParseException, NotEnoughMoneyException, SameAccountException, InvalidValueException;

}
