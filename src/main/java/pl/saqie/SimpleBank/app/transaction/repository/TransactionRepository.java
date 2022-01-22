package pl.saqie.SimpleBank.app.transaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.model.dto.ExpenseDto;
import pl.saqie.SimpleBank.app.account.model.dto.IncomeDto;
import pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query ("select new pl.saqie.SimpleBank.app.account.model.dto.ExpenseDto(t.description, t.value, t.createdDate, a.accountNumber, a.allExpenses) from Transaction t join t.accountFrom a where t.accountFrom = :id order by t.createdDate")
    Page<ExpenseDto> customFindExpensesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.account.model.dto.IncomeDto(t.description, t.value, t.createdDate, a.accountNumber, a.allIncomes) from Transaction t join t.accountTo a where t.accountTo = :id order by t.createdDate")
    Page<IncomeDto> customFindIncomesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.account.model.dto.MyAccountDto(b.allIncomes, b.allExpenses) from User u join u.bankAccount b where u.id = :id")
    MyAccountDto customFindMyAccountInformations(Long id);

}
