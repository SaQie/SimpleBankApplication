package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.dto.ActiveBanksDto;
import pl.saqie.SimpleBank.app.account.repository.BankAccountRepository;
import pl.saqie.SimpleBank.app.account.service.ActiveBanksService;

@Service
@AllArgsConstructor
public class ActiveBanksServiceImpl implements ActiveBanksService {

    private final BankAccountRepository repository;

    @Override
    public ActiveBanksDto getActiveBanksByUserId(Long id) {
        return repository.customFindActiveBanksDtoByUserId(id);
    }
}
