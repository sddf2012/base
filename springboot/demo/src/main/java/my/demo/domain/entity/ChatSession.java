package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import my.demo.config.DateToStringConverter;

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

    private String name;

    /**
     * 单聊唯一标识
     */
    private String userUnitedId;

    private String type;

    @Convert(converter = DateToStringConverter.class)
    private Date createAt;
}
