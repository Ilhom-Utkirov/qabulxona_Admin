package ttpu.qabulxona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttpu.qabulxona.constants.UserRoles;
import ttpu.qabulxona.entity.AdminUser;
import ttpu.qabulxona.entity.AdminUserRole;
import ttpu.qabulxona.repository.AdminUserRepository;
import ttpu.qabulxona.repository.AdminUserRoleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Service
public class PersonService {
   @Autowired
   private AdminUserRepository adminUserRepository;

   @Autowired
   private AdminUserRoleRepository roleRepository;

    public AdminUser create(AdminUser person, Integer[] roleIds) {
        person.setEnabled(true);
        person.setRegistered_date(new Date());
        person.setPassword(HashUtils.BCrypt(person.getPassword()));
        if(person.getUsername() == null || !person.exists()) {
            AdminUser adminUser = adminUserRepository.save(person);
            List<AdminUserRole> bankUserRoles = new ArrayList<>();
            for (Integer i = 0; i < roleIds.length; i++) {
                bankUserRoles.add(new AdminUserRole(UserRoles.findById(roleIds[i]), adminUser));
            }
            roleRepository.save(bankUserRoles);

            adminUserRepository.save(person);
            return adminUser;
        }
        return null;
    }

    public void update(AdminUser other,Integer[] roleIds) {
        AdminUser person = adminUserRepository.getOne(other.getId());
        person.merge(other);

       roleRepository.deleteByAdminUser_Id(other.getId());

        List<AdminUserRole> adminUserRoles = new ArrayList<>();
        for (Integer i = 0; i < roleIds.length; i++) {
            adminUserRoles.add(new AdminUserRole(UserRoles.findById(roleIds[i]), person));
        }

        roleRepository.save(adminUserRoles);

        if(other.getPassword().length()>0) {
            person.setPassword(HashUtils.BCrypt(other.getPassword()));
        }
        adminUserRepository.save(person);
    }

}
