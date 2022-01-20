package pl.saqie.SimpleBank.app.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.account.model.BankAccount;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query("select b from BankAccount b join fetch b.user where b.accountNumber = :accountNumber")
    Optional<BankAccount> findByAccountNumber(String accountNumber);

}
