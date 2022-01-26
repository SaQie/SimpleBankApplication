package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.dto.ActiveBanksDto;

public interface ActiveBanksService {

    ActiveBanksDto getActiveBanksByUserId(Long id);
}
