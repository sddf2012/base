package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2024/08/16 17:17
 */
@Data
@Entity
@Table(name = "ch_session")
public class ChatSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 单聊唯一标识
     */
    private String userUnitedId;

    private String type;

    private Date createAt;
}
