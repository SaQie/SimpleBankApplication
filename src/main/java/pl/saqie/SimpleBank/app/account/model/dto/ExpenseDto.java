package pl.saqie.SimpleBank.app.account.model.dto;

import lombok.*;
import pl.saqie.SimpleBank.app.utils.BasicDto;
import pl.saqie.SimpleBank.app.utils.TimeParser;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto extends BasicDto  {

    private String description;
    private BigDecimal amount;
    private String date;
    private String accountNumberFrom;
    private BigDecimal allExpenses;

    public ExpenseDto(String description, BigDecimal amount, LocalDateTime date, String accountNumberFrom, BigDecimal allExpenses) {
        this.description = description;
        this.amount = amount;
        this.date = TimeParser.parseTime(date);
        this.accountNumberFrom = accountNumberFrom;
        this.allExpenses = allExpenses;
    }
}
