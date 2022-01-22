package pl.saqie.SimpleBank.app.account.mapper.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.account.mapper.DashboardMapperToDto;
import pl.saqie.SimpleBank.app.account.model.BankAccount;
import pl.saqie.SimpleBank.app.account.model.dto.DashboardDto;
import pl.saqie.SimpleBank.app.user.model.User;
import pl.saqie.SimpleBank.app.user_information.model.UserInformation;

@Service
@AllArgsConstructor
public class DashboardDtoMapper implements DashboardMapperToDto {

    @Override
    public DashboardDto mapToDto(User user, BankAccount bankAccount, UserInformation userInformation, String quote) {
        return DashboardDto.builder()
                .firstName(userInformation.getFirstName())
                .lastName(userInformation.getLastName())
                .email(user.getEmail())
                .accountBalance(bankAccount.getAccountBalance().toString() + " zł")
                .accountNumber(bankAccount.getAccountNumber())
                .accountCreatedDate(bankAccount.getAccountCreatedDate())
                .accountNumberOfExpenses(bankAccount.getAccountNumberOfExpenses())
                .accountNumberOfRecipients(bankAccount.getAccountNumberOfRecipients())
                .adress(userInformation.getAdress())
                .gender(userInformation.getGender().getDescription())
                .pesel(user.getPesel())
                .city(userInformation.getCity())
                .postalCode(userInformation.getPostalCode())
                .telephoneNumber(userInformation.getTelephoneNumber())
                .quote(quote)
                .build();
    }
}
