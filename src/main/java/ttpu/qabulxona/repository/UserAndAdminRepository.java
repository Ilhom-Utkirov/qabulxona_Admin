package ttpu.qabulxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttpu.qabulxona.entity.UserAndAdmin;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
public interface UserAndAdminRepository extends JpaRepository<UserAndAdmin, Integer> {
}
