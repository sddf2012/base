package my.demo.repository;

import my.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liu peng bo
 * @date 2024/08/22 9:44
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String phone);
}
