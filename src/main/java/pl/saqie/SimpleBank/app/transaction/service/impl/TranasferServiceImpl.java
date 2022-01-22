package pl.saqie.SimpleBank.app.transaction.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.exception.AccountNotFoundException;
import pl.saqie.SimpleBank.app.account.exception.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.account.exception.SameAccountException;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.model.dto.TransferDto;
import pl.saqie.SimpleBank.app.account.repository.BankAccountRepository;
import pl.saqie.SimpleBank.app.transaction.service.IncomeMoneyService;
import pl.saqie.SimpleBank.app.transaction.service.TransferService;
import pl.saqie.SimpleBank.app.transaction.service.WithdrawalMoneyService;
import pl.saqie.SimpleBank.app.account.service.validator.TransferMoneyValidatorChain;
import pl.saqie.SimpleBank.app.transaction.service.TransactionService;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.utils.PriceParser;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TranasferServiceImpl implements TransferService {

    private final WithdrawalMoneyService withdrawalMoney;
    private final IncomeMoneyService incomeMoney;
    private final BankAccountRepository repository;
    private final List<TransferMoneyValidatorChain> validatorChain;
    private final PriceParser priceParser;
    private final TransactionService transactionService;


    @Override
    public void transfer(User user, TransferDto dto) throws AccountNotFoundException, ParseException, NotEnoughMoneyException, SameAccountException {
        BankAccount toBankAccount = findAccount(dto.getAccountNumber());
        BankAccount fromBankAccount = user.getBankAccount();
        fromBankAccount.setAccountNumberOfExpenses(fromBankAccount.getAccountNumberOfExpenses() + 1);
        BigDecimal value = priceParser.parserPrice(dto.getAmount());
        chain(fromBankAccount, value, toBankAccount);
        changeAccountsValues(toBankAccount, fromBankAccount, value);
        saveAccountsBalance(toBankAccount, fromBankAccount);
        transactionService.saveTransaction(fromBankAccount,toBankAccount, dto.getDescription(), value);
    }

    private void changeAccountsValues(BankAccount toBankAccount, BankAccount fromBankAccount, BigDecimal value) {
        withdrawalMoney.withdrawalMoney(fromBankAccount, value);
        incomeMoney.addMoney(toBankAccount, value);
    }


    private BankAccount findAccount(String accountNumber) throws AccountNotFoundException {
        return repository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFoundException("Podany numer konta jest nieprawidłowy."));
    }

    private void chain(BankAccount fromBankAccount, BigDecimal amount, BankAccount toBankAccount) throws NotEnoughMoneyException, SameAccountException {
        for (TransferMoneyValidatorChain moneyValidatorChain : validatorChain) {
            moneyValidatorChain.chain(fromBankAccount, amount, toBankAccount);
        }
    }

    private void saveAccountsBalance(BankAccount toBankAccount, BankAccount fromBankAccount) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(toBankAccount);
        accounts.add(fromBankAccount);
        repository.saveAll(accounts);
    }
}
