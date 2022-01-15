package pl.saqie.SimpleBank.app.account.mapper;

import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.model.dto.DashboardDto;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;

public interface DashboardMapperToDto {

    DashboardDto mapToDto(User user, BankAccount bankAccount, UserInformation userInformation);

}
