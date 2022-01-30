package pl.saqie.SimpleBank.app.config.application;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
public class ApplicationAdressConfig {

    private String applicationAdress;

}
