package springboot.login_security.utils.security.jwt;

import lombok.Data;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:53 PM
 */


@Data
public class JwtAuthRequest {

    private String username;

    private String password;

}
