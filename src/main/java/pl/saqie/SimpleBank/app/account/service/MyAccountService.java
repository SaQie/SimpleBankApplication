package pl.saqie.SimpleBank.app.account.service;

import pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto;

public interface MyAccountService {

    MyAccountDto getMyAccountInformation(Long id);

}
