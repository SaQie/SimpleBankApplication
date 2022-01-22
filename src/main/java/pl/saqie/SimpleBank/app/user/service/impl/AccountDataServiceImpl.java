package pl.saqie.SimpleBank.app.user.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.user.model.dto.AccountDataDto;
import pl.saqie.SimpleBank.app.user.repository.UserRepository;
import pl.saqie.SimpleBank.app.user.service.AccountDataService;

@Service
@AllArgsConstructor
public class AccountDataServiceImpl implements AccountDataService {

    private final UserRepository repository;

    @Override
    public AccountDataDto getAccountData(Long id) {
        return repository.customFindAccountDataDtoByUserId(id);
    }
}
