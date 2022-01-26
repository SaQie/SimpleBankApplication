package pl.saqie.SimpleBank.app.account.model.dto;

import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardDto{

    private String firstName;
    private String lastName;
    private String pesel;
    private String adress;
    private String city;
    private String postalCode;
    private String telephoneNumber;
    private String gender;
    private String email;
    private String accountNumber;
    private String accountBalance;
    private LocalDate accountCreatedDate;
    private int accountNumberOfRecipients;
    private int accountNumberOfExpenses;
    private String quote;
}
