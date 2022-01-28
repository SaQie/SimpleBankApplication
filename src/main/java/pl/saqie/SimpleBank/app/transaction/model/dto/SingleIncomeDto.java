package pl.saqie.SimpleBank.app.transaction.model.dto;

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
