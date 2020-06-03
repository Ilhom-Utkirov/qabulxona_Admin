package ttpu.qabulxona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ttpu.qabulxona.constants.UserRoles;
import ttpu.qabulxona.entity.AdminUser;
import ttpu.qabulxona.entity.AdminUserRole;
import ttpu.qabulxona.entity.UserAndAdmin;
import ttpu.qabulxona.repository.AdminUserRepository;
import ttpu.qabulxona.repository.UserAndAdminRepository;
import ttpu.qabulxona.service.PersonService;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Controller
@RequestMapping("/cmn")
public class AdminUsersController {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private UserAndAdminRepository userAndAdminRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping("/admin/users")
    public String getBankUsersPage(Model model){

        model.addAttribute("personnel", adminUserRepository.findAll());
        return "admin/adminUsersList";
    }


    @RequestMapping("/admin/users/form")
    public String getUserForm(
            Model model,
            @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        AdminUser person;
        if(id>0) {
            person = adminUserRepository.findOne(id);
        } else {
            person = new AdminUser();
        }

        Set<Integer> adminRoleIds = new HashSet<>();

        if(person.exists()) {
            Integer temp;
            for (AdminUserRole uRole : person.getRoles()) {
                temp = uRole.getRole().getId();
                if (!adminRoleIds.contains(temp)) {
                    adminRoleIds.add(temp);
                }
            }
        }
        model.addAttribute("roleEnums", UserRoles.values());
        model.addAttribute("role_id",adminRoleIds);
        model.addAttribute("person", person);

        return "admin/edit-modal";
    }

//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123"));
//    }

    @RequestMapping(value = "/banks/users/save", method = RequestMethod.POST)
    public String submitUser(
            AdminUser person,
            @RequestParam(value = "roleIds[]", required = false, defaultValue = "") Integer[] roleIds
    ) {
        AdminUser adminUser;
        if(person.exists()) {

            for (Integer i = 0; i < roleIds.length; i++) {
                person.addRole(new AdminUserRole(UserRoles.findById(roleIds[i]), person));
            }

           personService.update(person,roleIds);
        } else {
            adminUser =  personService.create(person,roleIds);

            UserAndAdmin userAndAdmin = new UserAndAdmin();
            userAndAdmin.setAdminUser(adminUser);
            userAndAdminRepository.save(userAndAdmin);
        }

        return "redirect:/cmn/admin/users";
    }



}
