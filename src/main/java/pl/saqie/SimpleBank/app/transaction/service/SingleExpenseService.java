package pl.saqie.SimpleBank.app.transaction.service;

import pl.saqie.SimpleBank.app.transaction.exception.TransactionNotFoundException;
import pl.saqie.SimpleBank.app.transaction.model.dto.SingleExpenseDto;
import pl.saqie.SimpleBank.app.user.model.User;

public interface SingleExpenseService {

    SingleExpenseDto getSingleExpenseById(Long id, User user) throws TransactionNotFoundException;

}
