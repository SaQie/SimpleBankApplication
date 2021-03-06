package pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.AccountNotFoundException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.InvalidValueException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.NotEnoughMoneyException;
import pl.saqie.SimpleBank.app.common.exceptions.transaction.SameAccountException;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccount;
import pl.saqie.SimpleBank.app.component.transaction.usecase.transfermoney.validator.TransferMoneyValidatorChain;
import pl.saqie.SimpleBank.app.component.bankaccount.BankAccountRepository;
import pl.saqie.SimpleBank.app.component.transaction.usecase.moneyincome.MoneyIncomeUseCase;
import pl.saqie.SimpleBank.app.component.transaction.usecase.moneyexpense.MoneyExpenseUseCase;
import pl.saqie.SimpleBank.app.component.transaction.usecase.createtransaction.CreateTransactionUseCase;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.common.price.PriceParser;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TranasferMoneyUseCaseImpl implements TransferMoneyUseCase {

    private final MoneyExpenseUseCase withdrawalMoney;
    private final MoneyIncomeUseCase incomeMoney;
    private final BankAccountRepository repository;
    private final List<TransferMoneyValidatorChain> validatorChain;
    private final PriceParser priceParser;
    private final CreateTransactionUseCase transactionService;


    @Override
    public void transfer(User user, TransferMoneyDto dto) throws AccountNotFoundException, ParseException, NotEnoughMoneyException, SameAccountException, InvalidValueException {
        BankAccount toBankAccount = findAccount(dto.getAccountNumber());
        BankAccount fromBankAccount = user.getBankAccount();
        BigDecimal value = priceParser.parserPrice(dto.getAmount());
        chain(fromBankAccount, value, toBankAccount);
        changeAccountsValues(toBankAccount, fromBankAccount, value);
        saveAccountsBalance(toBankAccount, fromBankAccount);
        transactionService.saveTransaction(fromBankAccount,toBankAccount, dto.getDescription(), value);
    }

    private void chain(BankAccount fromBankAccount, BigDecimal amount, BankAccount toBankAccount) throws NotEnoughMoneyException, SameAccountException, InvalidValueException {
        for (TransferMoneyValidatorChain moneyValidatorChain : validatorChain) {
            moneyValidatorChain.chain(fromBankAccount, amount, toBankAccount);
        }
    }

    private void changeAccountsValues(BankAccount toBankAccount, BankAccount fromBankAccount, BigDecimal value) {
        withdrawalMoney.withdrawalMoney(fromBankAccount, value);
        incomeMoney.addMoney(toBankAccount, value);
    }

    private BankAccount findAccount(String accountNumber) throws AccountNotFoundException {
        return repository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFoundException("Podany numer konta jest nieprawid??owy."));
    }

    private void saveAccountsBalance(BankAccount toBankAccount, BankAccount fromBankAccount) {
        List<BankAccount> accounts = assignBankAccountsToList(toBankAccount, fromBankAccount);
        repository.saveAll(accounts);
    }

    private List<BankAccount> assignBankAccountsToList(BankAccount toBankAccount, BankAccount fromBankAccount) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(toBankAccount);
        accounts.add(fromBankAccount);
        return accounts;
    }
}
