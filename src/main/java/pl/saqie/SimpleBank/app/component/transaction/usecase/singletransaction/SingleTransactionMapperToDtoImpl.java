package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.transaction.Transaction;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDtoFrom;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.expense.SingleExpenseDtoTo;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDto;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDtoFrom;
import pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income.SingleIncomeDtoTo;
import pl.saqie.SimpleBank.app.common.time.TimeParser;

@Service
public class SingleTransactionMapperToDtoImpl implements SingleTransactionMapperToDto {

    @Override
    public SingleIncomeDto mapToSingleIncomeDto(Transaction transaction) {
        return SingleIncomeDto.builder()
                .date(TimeParser.parseTime(transaction.getCreatedDate()))
                .description(transaction.getDescription())
                .value(transaction.getValue())
                .from(TransactionMapperToSingleIncomeDtoFrom.mapToDto(transaction))
                .to(TransactionMapperToSingleIncomeDtoTo.mapToDto(transaction))
                .build();
    }

    @Override
    public SingleExpenseDto mapToSingleExpenseDto(Transaction transaction) {
        return SingleExpenseDto.builder()
                .date(TimeParser.parseTime(transaction.getCreatedDate()))
                .description(transaction.getDescription())
                .value(transaction.getValue())
                .from(TransactionMapperToSingleExpenseDtoFrom.mapToDto(transaction))
                .to(TransactionMapperToSingleExpenseDtoTo.mapToDto(transaction))
                .build();
    }

    static class TransactionMapperToSingleExpenseDtoFrom{
        public static SingleExpenseDtoFrom mapToDto(Transaction transaction){
            return SingleExpenseDtoFrom.builder()
                    .firstName(transaction.getAccountFrom().getUser().getUserInformation().getFirstName())
                    .lastName(transaction.getAccountFrom().getUser().getUserInformation().getLastName())
                    .adress(transaction.getAccountFrom().getUser().getUserInformation().getAdress())
                    .postalCode(transaction.getAccountFrom().getUser().getUserInformation().getPostalCode())
                    .city(transaction.getAccountFrom().getUser().getUserInformation().getCity())
                    .bankAccountNumber(transaction.getAccountFrom().getAccountNumber())
                    .build();
        }
    }

    static class TransactionMapperToSingleExpenseDtoTo{
        public static SingleExpenseDtoTo mapToDto(Transaction transaction){
            return SingleExpenseDtoTo.builder()
                    .firstName(transaction.getAccountTo().getUser().getUserInformation().getFirstName())
                    .lastName(transaction.getAccountTo().getUser().getUserInformation().getLastName())
                    .adress(transaction.getAccountTo().getUser().getUserInformation().getAdress())
                    .postalCode(transaction.getAccountTo().getUser().getUserInformation().getPostalCode())
                    .city(transaction.getAccountTo().getUser().getUserInformation().getCity())
                    .bankAccountNumber(transaction.getAccountTo().getAccountNumber())
                    .build();
        }
    }

    static class TransactionMapperToSingleIncomeDtoTo{
        public static SingleIncomeDtoTo mapToDto(Transaction transaction){
            return SingleIncomeDtoTo.builder()
                    .firstName(transaction.getAccountTo().getUser().getUserInformation().getFirstName())
                    .lastName(transaction.getAccountTo().getUser().getUserInformation().getLastName())
                    .adress(transaction.getAccountTo().getUser().getUserInformation().getAdress())
                    .postalCode(transaction.getAccountTo().getUser().getUserInformation().getPostalCode())
                    .city(transaction.getAccountTo().getUser().getUserInformation().getCity())
                    .bankAccountNumber(transaction.getAccountTo().getAccountNumber())
                    .build();
        }
    }


    static class TransactionMapperToSingleIncomeDtoFrom{
        public static SingleIncomeDtoFrom mapToDto(Transaction transaction){
            return SingleIncomeDtoFrom.builder()
                    .firstName(transaction.getAccountFrom().getUser().getUserInformation().getFirstName())
                    .lastName(transaction.getAccountFrom().getUser().getUserInformation().getLastName())
                    .adress(transaction.getAccountFrom().getUser().getUserInformation().getAdress())
                    .postalCode(transaction.getAccountFrom().getUser().getUserInformation().getPostalCode())
                    .city(transaction.getAccountFrom().getUser().getUserInformation().getCity())
                    .bankAccountNumber(transaction.getAccountFrom().getAccountNumber())
                    .build();
        }
    }

}
