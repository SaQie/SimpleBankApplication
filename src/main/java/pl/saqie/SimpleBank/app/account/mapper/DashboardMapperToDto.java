package pl.saqie.SimpleBank.app.account.mapper;

import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;
import pl.saqie.SimpleBank.app.utils.BasicDto;

public interface DashboardMapperToDto {

    BasicDto mapToDto(User user, BankAccount bankAccount, UserInformation userInformation);

}
