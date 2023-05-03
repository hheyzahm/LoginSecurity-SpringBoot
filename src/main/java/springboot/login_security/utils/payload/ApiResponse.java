package springboot.login_security.utils.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:45 PM
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success;
}
