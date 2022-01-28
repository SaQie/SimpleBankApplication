package pl.saqie.SimpleBank.app.transaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.transaction.model.dto.ExpensesDto;
import pl.saqie.SimpleBank.app.transaction.model.dto.IncomesDto;
import pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query ("select new pl.saqie.SimpleBank.app.transaction.model.dto.ExpensesDto(t.id,t.description, t.value, t.createdDate, a.accountNumber) from Transaction t join t.accountTo a where t.accountFrom = :id order by t.createdDate")
    Page<ExpensesDto> customFindExpensesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.transaction.model.dto.IncomesDto(t.id,t.description, t.value, t.createdDate, a.accountNumber) from Transaction t join t.accountFrom a where t.accountTo = :id order by t.createdDate")
    Page<IncomesDto> customFindIncomesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto(b.allIncomes, b.allExpenses) from User u join u.bankAccount b where u.id = :id")
    MyAccountDto customFindMyAccountInformations(Long id);
}
