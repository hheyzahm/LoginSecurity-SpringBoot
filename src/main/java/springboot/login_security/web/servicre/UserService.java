package springboot.login_security.web.servicre;

import springboot.login_security.web.domain.dto.UserDto;

import java.util.List;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:39 PM
 */


public interface UserService {
    UserDto registerNewUser(UserDto user);
    UserDto registerNewAdmin(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
