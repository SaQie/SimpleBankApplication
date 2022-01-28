package pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard;

import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard.DashboardDto;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.userinformation.UserInformation;


public interface DashboardMapperToDto {

    DashboardDto mapToDto(User user, BankAccount bankAccount, UserInformation userInformation, String quote);

}
