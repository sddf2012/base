package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import my.demo.config.DateToStringConverter;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2024/08/19 16:33
 */
@Data
@Entity
@Table(name = "ch_message")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sessionId;

    private Long senderId;

    private Long receiverId;

    private String contentType;

    private String content;

    @Convert(converter = DateToStringConverter.class)
    private Date sendAt;

    private String readFlag;

}
