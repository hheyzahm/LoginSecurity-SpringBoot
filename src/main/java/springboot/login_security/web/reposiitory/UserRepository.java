package springboot.login_security.web.reposiitory;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.login_security.web.domain.model.User;

import java.util.Optional;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:26 PM
 */


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
