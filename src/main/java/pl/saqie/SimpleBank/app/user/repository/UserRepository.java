package pl.saqie.SimpleBank.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.user.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPesel(String pesel);

    boolean existsByPesel(String pesel);

    boolean existsByEmail(String email);
}
