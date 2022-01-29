package pl.saqie.SimpleBank.app.component.recipient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients.AllRecipientsDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {

    Optional<List<Recipient>> findAllByUserId(Long id);

    @Query("select new pl.saqie.SimpleBank.app.component.recipient.usecase.allrecipients.AllRecipientsDto(r.id, r.bankAccount.user.userInformation.firstName, r.bankAccount.user.userInformation.lastName, r.bankAccount.accountNumber, r.addedDate) from Recipient r where r.user.id = :id")
    Page<AllRecipientsDto> customFindAllRecipientsDtoByUserId(Long id, Pageable pageable);

}
