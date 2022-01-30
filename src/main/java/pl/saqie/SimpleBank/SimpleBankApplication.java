package pl.saqie.SimpleBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SimpleBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBankApplication.class, args);
	}

}
