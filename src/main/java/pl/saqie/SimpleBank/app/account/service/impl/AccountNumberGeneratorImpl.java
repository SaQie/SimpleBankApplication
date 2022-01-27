package pl.saqie.SimpleBank.app.account.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.saqie.SimpleBank.app.account.service.AccountNumberGenerator;

import java.util.Random;

@Component
@AllArgsConstructor
public class AccountNumberGeneratorImpl implements AccountNumberGenerator {

    @Override
    public String createAccountNumber() {
        return generateRandomAccountNumber();
    }

    private String generateRandomAccountNumber(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <= 25; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
