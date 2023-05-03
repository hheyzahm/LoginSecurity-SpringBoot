package springboot.login_security.utils.exception;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:43 PM
 */


public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);

    }

    public ApiException() {
        super();

    }

}
