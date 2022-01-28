package pl.saqie.SimpleBank.app.transaction.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleExpenseDto {

    private SingleExpenseDtoFrom from;
    private SingleExpenseDtoTo to;
    private String date;
    private String description;
    private BigDecimal value;

}
