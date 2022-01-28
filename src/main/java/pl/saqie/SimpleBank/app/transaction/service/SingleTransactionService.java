package pl.saqie.SimpleBank.app.transaction.service;

import pl.saqie.SimpleBank.app.transaction.exception.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleIncomeDto;
import pl.saqie.SimpleBank.app.user.model.User;

public interface SingleTransactionService {

    SingleExpenseDto getSingleExpenseById(Long id, User user) throws TransactionNotFoundException;

    SingleIncomeDto getSingleIncomeById(Long id, User user) throws TransactionNotFoundException;

}
