package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.user.model.User;

public interface BankAccountCreateService {

    BankAccount createNewBankAccount(User user);

}
