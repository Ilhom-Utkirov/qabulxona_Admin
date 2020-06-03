package ttpu.qabulxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttpu.qabulxona.entity.AdminUser;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
    AdminUser findByUsername(String username);
}
