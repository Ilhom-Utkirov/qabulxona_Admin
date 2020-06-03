package ttpu.qabulxona.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ttpu.qabulxona.entity.AdminUser;
import ttpu.qabulxona.repository.AdminUserRepository;


import javax.servlet.http.HttpServletRequest;



/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Service
@Qualifier("userInfoService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public UserDetails loadUserByUsername(final String usernameWithPostfix) throws UsernameNotFoundException {


        AdminUser adminUser = adminUserRepository.findByUsername(usernameWithPostfix);
        if(adminUser != null)
            return new AdminUserDetails(adminUser);



        String username = "", postfix ="";

        if(usernameWithPostfix.contains("_")){
            int delimeter = usernameWithPostfix.lastIndexOf('_'); //last underscore sign in the username
            username = usernameWithPostfix.substring(0, delimeter);
            postfix = usernameWithPostfix.substring(delimeter);
        }


        AdminUser _adminUser = adminUserRepository.findByUsername(username);
        if(_adminUser != null)
            return new AdminUserDetails(_adminUser);


        throw new UsernameNotFoundException("User [" + username + "] is not found.");
    }





}
