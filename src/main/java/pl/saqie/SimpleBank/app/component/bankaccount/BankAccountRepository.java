package pl.saqie.SimpleBank.app.component.bankaccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks.ActiveBanksDto;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("select b from BankAccount b join fetch b.user where b.accountNumber = :accountNumber")
    Optional<BankAccount> findByAccountNumber(String accountNumber);

    @Query("select new pl.saqie.SimpleBank.app.component.bankaccount.usecase.activebanks.ActiveBanksDto(b.accountNumber, b.accountBalance, b.accountCreatedDate) from BankAccount b where b.user.id = :id")
    ActiveBanksDto customFindActiveBanksDtoByUserId(Long id);

    BankAccount findByUserId(Long id);

}
