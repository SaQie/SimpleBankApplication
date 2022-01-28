package pl.saqie.SimpleBank.app.transaction.mapper.impl;

import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.transaction.mapper.TransactionMapperToDto;
import pl.saqie.SimpleBank.app.transaction.model.Transaction;
import pl.saqie.SimpleBank.app.transaction.model.dto.*;
import pl.saqie.SimpleBank.app.utils.TimeParser;

@Service
public class TransactionMapperToDtoImpl implements TransactionMapperToDto {

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
