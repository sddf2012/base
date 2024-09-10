package my.demo.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author liu peng bo
 * @date 2024/09/02 15:17
 */
@Data
public class MessageVo {
    private Long id;

    private Long sessionId;

    private Long senderId;

    private Long receiverId;

    private String contentType;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendAt;

    private String readFlag;
}
