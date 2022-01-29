package pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.saqie.SimpleBank.app.component.recipient.RecipientRepository;
import pl.saqie.SimpleBank.app.component.user.User;

@Service
@AllArgsConstructor
public class AllRecipientsUseCaseImpl implements AllRecipientsUseCase{

    private final RecipientRepository recipientRepository;

    @Override
    public Page<AllRecipientsDto> findAllRecipients(User user, int page) {
        Pageable pageable = PageRequest.of(page -1, 8);
        return recipientRepository.customFindAllRecipientsDtoByUserId(user.getId(),pageable);
    }
}
