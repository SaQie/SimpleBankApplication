package pl.saqie.SimpleBank.app.component.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.saqie.SimpleBank.app.component.user.User;
import pl.saqie.SimpleBank.app.component.user.usecase.accountdata.AccountDataDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByPesel(String pesel);

    boolean existsByPesel(String pesel);

    boolean existsByEmail(String email);

    @Query("select new pl.saqie.SimpleBank.app.component.user.usecase.accountdata.AccountDataDto(i.firstName, i.lastName, u.pesel, i.adress, i.city, i.postalCode, i.telephoneNumber, i.gender, u.email, u.createdDate, b.accountNumber) from User u join u.bankAccount b join u.userInformation i where u.id = :id")
    AccountDataDto customFindAccountDataDtoByUserId(Long id);

    Optional<User> findByEmailActivationToken(String token);

    @Query("select u.id from User u where u.emailActivationTokenExpiredDate <= :time")
    List<Long> customFindAllUsersWithExpiredActivationToken(LocalDateTime time);
}
