package springboot.login_security.web.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import springboot.login_security.utils.constants.TableName;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:09 PM
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = TableName.ROLE)
public class Role extends BaseModel {
    private String name;
}
