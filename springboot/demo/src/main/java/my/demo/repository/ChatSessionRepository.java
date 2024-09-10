package my.demo.repository;

import my.demo.domain.entity.ChatSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2024/08/26 11:47
 */
public interface ChatSessionRepository extends JpaRepository<ChatSession,Long> {
    List<ChatSession> findByUserUnitedId(String userUnitedId);
}
