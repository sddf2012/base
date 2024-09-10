package my.demo.repository;

import my.demo.domain.entity.ChatSessionUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/09/06 11:36
 */
public interface ChatSessionUserRepository extends JpaRepository<ChatSessionUser, Long> {
    List<ChatSessionUser> findBySessionIdAndUserIdNot(Long sessionId, Long userId);
}
