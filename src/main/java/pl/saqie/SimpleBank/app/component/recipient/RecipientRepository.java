package pl.saqie.SimpleBank.app.component.recipient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipientRepository extends JpaRepository<Recipient, Long> {

    Optional<List<Recipient>> findAllByUserId(Long id);

}
