package pl.saqie.SimpleBank.app.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
