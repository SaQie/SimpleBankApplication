package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.mapper.DashboardMapperToDto;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.model.dto.DashboardDto;
import pl.saqie.SimpleBank.app.account.service.DashboardService;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;
import pl.saqie.SimpleBank.app.account.service.RandomQuote;

@Service
@AllArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final DashboardMapperToDto mapperToDto;
    private final RandomQuote randomQuote;

    @Override
    public DashboardDto getDashboardInformations(User user) {
        return mapToDashboardDto(user);
    }

    private DashboardDto mapToDashboardDto(User user) {
        BankAccount userBankAccount = user.getBankAccount();
        UserInformation userInformations = user.getUserInformation();
        String quote = randomQuote.generateRandomQuote();
        return mapperToDto.mapToDto(user,userBankAccount,userInformations, quote);
    }
}
