package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.exception.AccountNotFoundException;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.account.model.dto.TransferDto;
import pl.saqie.SimpleBank.app.user.model.User;

import java.text.ParseException;

public interface TransferService {

    void transfer(User user, TransferDto dto) throws AccountNotFoundException, ParseException, NotEnoughMoneyException, SameAccountException;

}
