package springboot.login_security.web.domain.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Hazeem Hassan
 * @created 03/05/2023 3:10 PM
 */

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private int id;
}
