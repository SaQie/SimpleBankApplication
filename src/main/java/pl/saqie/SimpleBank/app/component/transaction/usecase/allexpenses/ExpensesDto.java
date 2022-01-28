package pl.saqie.SimpleBank.app.component.transaction.usecase.allexpenses;

import lombok.*;
import pl.saqie.SimpleBank.app.common.time.TimeParser;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesDto {

    private Long id;
    private String description;
    private BigDecimal amount;
    private String date;
    private String accountNumberFrom;

    public ExpensesDto(Long id, String description, BigDecimal amount, LocalDateTime date, String accountNumberFrom) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = TimeParser.parseTime(date);
        this.accountNumberFrom = accountNumberFrom;
    }
}
