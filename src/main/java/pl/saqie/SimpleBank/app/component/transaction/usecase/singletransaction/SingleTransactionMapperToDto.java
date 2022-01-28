package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction;

import pl.saqie.SimpleBank.app.component.transaction.Transaction;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDto;

public interface SingleTransactionMapperToDto {

    SingleExpenseDto mapToSingleExpenseDto(Transaction transaction);

    SingleIncomeDto mapToSingleIncomeDto(Transaction transaction);

}
