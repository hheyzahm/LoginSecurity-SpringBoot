package springboot.login_security.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.login_security.utils.exception.ResourceNotFoundException;
import springboot.login_security.web.domain.model.User;
import springboot.login_security.web.reposiitory.UserRepository;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:47 PM
 */

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // loading user from database by username
        User user = this.userRepo.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
        return user;
    }

}
