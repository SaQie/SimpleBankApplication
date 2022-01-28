package pl.saqie.SimpleBank.app.transaction.mapper;

import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;

public interface TransactionMapperToDto {

    SingleExpenseDto mapToDto(Transaction transaction);

}
