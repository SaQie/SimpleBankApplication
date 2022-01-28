package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction;

import pl.saqie.SimpleBank.app.common.exceptions.transaction.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDto;
import pl.saqie.SimpleBank.app.component.user.User;

public interface SingleTransactionUseCase {

    SingleExpenseDto getSingleExpenseById(Long id, User user) throws TransactionNotFoundException;

    SingleIncomeDto getSingleIncomeById(Long id, User user) throws TransactionNotFoundException;

}
