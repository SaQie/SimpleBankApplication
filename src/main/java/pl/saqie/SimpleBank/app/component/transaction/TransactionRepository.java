package pl.saqie.SimpleBank.app.component.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses.ExpensesDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes.IncomesDto;
import pl.saqie.SimpleBank.app.component.bankaccount.usecase.myaccount.MyAccountDto;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query ("select new pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses.ExpensesDto(t.id,t.description, t.value, t.createdDate, a.accountNumber) from Transaction t join t.accountTo a where t.accountFrom = :id order by t.createdDate")
    Page<ExpensesDto> customFindExpensesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.component.transaction.usecase.allincomes.IncomesDto(t.id,t.description, t.value, t.createdDate, a.accountNumber) from Transaction t join t.accountFrom a where t.accountTo = :id order by t.createdDate")
    Page<IncomesDto> customFindIncomesByDate(BankAccount id, Pageable pageable);

    @Query("select new pl.saqie.SimpleBank.app.component.bankaccount.usecase.myaccount.MyAccountDto(b.allIncomes, b.allExpenses) from User u join u.bankAccount b where u.id = :id")
    MyAccountDto customFindMyAccountInformations(Long id);
}
