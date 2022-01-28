package pl.saqie.SimpleBank.app.transaction.mapper;

import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleIncomeDto;

public interface TransactionMapperToDto {

    SingleExpenseDto mapToSingleExpenseDto(Transaction transaction);

    SingleIncomeDto mapToSingleIncomeDto(Transaction transaction);

}
