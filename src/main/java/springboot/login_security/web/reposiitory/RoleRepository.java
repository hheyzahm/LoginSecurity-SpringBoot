package springboot.login_security.web.reposiitory;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.login_security.web.domain.model.Role;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:36 PM
 */


public interface RoleRepository extends JpaRepository<Role, Integer> {

}
