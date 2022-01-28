package pl.saqie.SimpleBank.app.component.transaction.usecase.singletransaction.dto.income;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleIncomeDto {

    private SingleIncomeDtoFrom from;
    private SingleIncomeDtoTo to;
    private String date;
    private String description;
    private BigDecimal value;

}
