package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.Account;
import pl.saqie.SimpleBank.app.user.model.User;

public interface AccountCreateService {

    Account createNewAccount(User user);

}
