package pl.saqie.SimpleBank.app.user.service;

import pl.saqie.SimpleBank.app.user.model.dto.AccountDataDto;

public interface AccountDataService {

    AccountDataDto getAccountData(Long id);

}
