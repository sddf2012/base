package my.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    private String sessionId;

    private String senderId;

    private String contentType;

    private String content;

    private Date sendAt;

    private String readFlag;

}
