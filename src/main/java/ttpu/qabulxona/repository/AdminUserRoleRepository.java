package ttpu.qabulxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttpu.qabulxona.entity.AdminUserRole;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
public interface AdminUserRoleRepository extends JpaRepository<AdminUserRole, Integer> {

   Long deleteByAdminUser_Id(Integer id);
}
