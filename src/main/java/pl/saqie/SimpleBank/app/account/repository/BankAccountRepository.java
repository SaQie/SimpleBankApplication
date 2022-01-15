package pl.saqie.SimpleBank.app.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.account.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    boolean existsByAccountNumber(String accountNumber);

}
