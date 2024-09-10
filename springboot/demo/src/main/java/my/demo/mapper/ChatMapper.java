package my.demo.mapper;

import my.demo.domain.vo.SessionInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/08/26 16:49
 */
@Mapper
public interface ChatMapper {
    List<SessionInfo> querySingleChatSession(@Param("userId") Long userId);

}
