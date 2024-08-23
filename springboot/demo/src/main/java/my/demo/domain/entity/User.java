package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * @author liu peng bo
 * @date 2024/08/16 16:57
 */
@Data
@Entity
@Table(name = "ch_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String name;

    private String pwd;
}
