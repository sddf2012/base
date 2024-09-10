package my.demo.domain.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/08/28 11:44
 */
@Data
public class SessionInfo {
    private String sessionId;

    private String name;

    private String type;

    private String userUnitedId;

    private Long targetUserId;

    private String targetUserName;

    private String targetUserPhone;

    private Long unReadCount=0L;

    private List<MessageVo> messages;

}
