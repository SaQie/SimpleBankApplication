package pl.saqie.SimpleBank.app.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
