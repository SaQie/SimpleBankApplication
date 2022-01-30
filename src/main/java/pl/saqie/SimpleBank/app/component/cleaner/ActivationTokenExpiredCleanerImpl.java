package pl.saqie.SimpleBank.app.component.cleaner;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ActivationTokenExpiredCleanerImpl implements ActivationTokenExpiredCleaner{

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(ActivationTokenExpiredCleanerImpl.class);

    @Scheduled(cron = "0 0 0/1 1/1 * ?")
    public void clearAccountsWithExpiredActivationToken(){
        logger.info("Przeszukuję baze w poszukiwaniu nieaktywnych użytkowników.");
        List<Long> longs = userRepository.customFindAllUsersWithExpiredActivationToken(LocalDateTime.now());
        removeFindedAccounts(longs);
    }

    private void removeFindedAccounts(List<Long> longs) {
        userRepository.deleteAllById(longs);
        longs.forEach(id -> logger.info("Usunięto konto użytkownika o id: " + id));
    }

}
