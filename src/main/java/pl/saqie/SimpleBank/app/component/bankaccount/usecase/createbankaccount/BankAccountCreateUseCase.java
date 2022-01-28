package pl.saqie.SimpleBank.app.component.bankaccount.usecase.createbankaccount;

import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.user.User;

public interface BankAccountCreateUseCase {

    BankAccount createNewBankAccount(User user);

}
