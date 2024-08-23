package my.demo.domain.cnst;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liu peng bo
 * @date 2024/08/16 17:20
 */
public interface ChatConst {
    @AllArgsConstructor
    @Getter
    enum UniqueIdType {
        USER_ID("USER_ID", "用户id"),
        SESSION_ID("SESSION_ID", "会话id"),
        MESSAGE_ID("MESSAGE_ID", "消息id"),
        ;
        private final String code;

        private final String name;

    }

    @AllArgsConstructor
    @Getter
    enum YesAndNo {
        YES("1", "是"),
        NO("0", "否");

        private final String code;

        private final String name;

    }

    @AllArgsConstructor
    @Getter
    enum SessionType {
        SINGLE_CHAT("1", "单聊"),
        GROUP_CHAT("2", "群聊");

        private final String code;

        private final String name;

    }

    @AllArgsConstructor
    @Getter
    enum ContentType {
        TEXT("1", "文本"),
        ;

        private final String code;

        private final String name;

    }
}
