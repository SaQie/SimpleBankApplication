package pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccountRepository;

@Service
@AllArgsConstructor
public class ActiveBanksUseCaseImpl implements ActiveBanksUseCase {

    private final BankAccountRepository repository;

    @Override
    public ActiveBanksDto getActiveBanksByUserId(Long id) {
        return repository.customFindActiveBanksDtoByUserId(id);
    }
}
