package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto;
import pl.saqie.SimpleBank.app.account.service.MyAccountService;
import pl.saqie.SimpleBank.app.transaction.repository.TransactionRepository;
import pl.saqie.SimpleBank.app.user.model.User;

@Service
@AllArgsConstructor
public class MyAccountServiceImpl implements MyAccountService {

    private final TransactionRepository repository;

    @Override
    public MyAccountDto getMyAccountInformation(Long id) {
        return repository.customFindMyAccountInformations(id);
    }
}
