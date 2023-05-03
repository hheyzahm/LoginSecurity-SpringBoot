package springboot.login_security.utils.security.jwt;

import lombok.Data;
import springboot.login_security.web.domain.dto.UserDto;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:53 PM
 */


@Data
public class JwtAuthResponse {

    private String token;

    private UserDto user;
}
