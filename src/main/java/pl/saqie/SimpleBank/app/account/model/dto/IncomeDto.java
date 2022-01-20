package pl.saqie.SimpleBank.app.account.model.dto;

import lombok.*;
import pl.saqie.SimpleBank.app.utils.TimeParser;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDto {

    private String description;
    private BigDecimal amount;
    private String date;
    private String accountNumberFrom;
    private BigDecimal allIncomes;

    public IncomeDto(String description, BigDecimal amount, LocalDateTime date, String accountNumberFrom, BigDecimal allIncomes) {
        this.description = description;
        this.amount = amount;
        this.date = TimeParser.parseTime(date);
        this.accountNumberFrom = accountNumberFrom;
        this.allIncomes = allIncomes;
    }
}
