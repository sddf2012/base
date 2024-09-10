package my.demo.domain.bo;

import lombok.Data;

/**
 * @author liu peng bo
 * @date 2024/08/30 11:54
 */
@Data
public class SendMessageBo {
    private Long sessionId;

    private Long senderId;

    private Long receiverId;

    private String contentType;

    private String content;
}
