package pl.saqie.SimpleBank.app.account.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActiveBanksDto {

    private String accountNumber;
    private BigDecimal accountBalance;
    private LocalDate createdDate;
}
