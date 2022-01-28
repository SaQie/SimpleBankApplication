package pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks;

public interface ActiveBanksUseCase {

    ActiveBanksDto getActiveBanksByUserId(Long id);
}
