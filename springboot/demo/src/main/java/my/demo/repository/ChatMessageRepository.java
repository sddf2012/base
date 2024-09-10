package my.demo.repository;

import my.demo.domain.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/09/02 15:08
 */
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
    List<ChatMessage> findBySessionIdOrderBySendAtAsc(Long sessionId);

    List<ChatMessage> findBySessionIdAndIdGreaterThanOrderBySendAtAsc(Long sessionId,Long id);

}
