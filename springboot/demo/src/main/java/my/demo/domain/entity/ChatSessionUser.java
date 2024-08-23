package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;


/**
 * @author liu peng bo
 * @date 2024/08/21 15:23
 */
@Data
@Entity
@Table(name = "ch_session_user")
public class ChatSessionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;

    private Long userId;
}
