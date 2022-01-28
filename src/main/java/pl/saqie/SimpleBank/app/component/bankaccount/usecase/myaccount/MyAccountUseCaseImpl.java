package pl.saqie.SimpleBank.app.component.bankaccount.usecase.myaccount;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.transaction.TransactionRepository;

@Service
@AllArgsConstructor
public class MyAccountUseCaseImpl implements MyAccountUseCase {

    private final TransactionRepository repository;

    @Override
    public MyAccountDto getMyAccountInformation(Long id) {
        return repository.customFindMyAccountInformations(id);
    }
}
