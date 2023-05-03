package springboot.login_security.utils.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:42 PM
 */


@Getter
@Setter
public class  ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}