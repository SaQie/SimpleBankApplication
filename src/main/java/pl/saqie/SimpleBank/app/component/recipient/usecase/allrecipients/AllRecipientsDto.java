package pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllRecipientsDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String accountNumber;
    private LocalDate dateAdded;

}
