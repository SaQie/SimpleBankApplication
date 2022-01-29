package pl.saqie.SimpleBank.app.component.bankaccount.usecase.dashboard;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccountRepository;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.userinformation.UserInformation;
import pl.saqie.SimpleBank.app.component.quote.RandomQuote;

@Service
@AllArgsConstructor
public class DashboardUseCaseImpl implements DashboardUseCase {

    private final DashboardMapperToDto mapperToDto;
    private final BankAccountRepository repository;
    private final RandomQuote randomQuote;

    @Override
    public DashboardDto getDashboardInformations(User user) {
        return mapToDashboardDto(user);
    }

    private DashboardDto mapToDashboardDto(User user) {
        BankAccount userBankAccount = repository.findByUserId(user.getId());
        UserInformation userInformations = user.getUserInformation();
        String quote = randomQuote.generateRandomQuote();
        return mapperToDto.mapToDto(user,userBankAccount,userInformations, quote);
    }
}
