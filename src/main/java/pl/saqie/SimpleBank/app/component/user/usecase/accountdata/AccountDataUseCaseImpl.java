package pl.saqie.SimpleBank.app.component.user.usecase.accountdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

@Service
@AllArgsConstructor
public class AccountDataUseCaseImpl implements AccountDataUseCase {

    private final UserRepository repository;

    @Override
    public AccountDataDto getAccountData(Long id) {
        return repository.customFindAccountDataDtoByUserId(id);
    }
}
