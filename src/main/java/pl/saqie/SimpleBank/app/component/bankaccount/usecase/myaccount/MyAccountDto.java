package pl.saqie.SimpleBank.app.component.bankaccount.usecase.myaccount;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyAccountDto {

    private BigDecimal incomes;
    private BigDecimal expenses;

}
