package ttpu.qabulxona.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ttpu.qabulxona.constants.UserType;
import ttpu.qabulxona.entity.AdminUser;
import ttpu.qabulxona.entity.AdminUserRole;
import ttpu.qabulxona.entity.UserAndAdmin;

import java.util.*;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
public class AdminUserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String surname;
    Set<GrantedAuthority> authorities;
    List<Integer> allowed_providers_ids;

    public AdminUserDetails(AdminUser adminUser) {
        this.id = adminUser.getId();
        this.username = adminUser.getUsername();
        this.name = adminUser.getName();
        this.surname = adminUser.getSurname();
        this.password = adminUser.getPassword();

        if(this.authorities==null) this.authorities = new HashSet<>();

        authorities.add(new SimpleGrantedAuthority(UserType.ADMIN_USER.name()));

        adminUser.getRoles();
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for(AdminUserRole userRole : adminUser.getRoles()){
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole().name()));
        }

        authorities.addAll(setAuths);

        this.allowed_providers_ids = new ArrayList<>();
        for(UserAndAdmin admin: adminUser.getAllProviders()) {
            this.allowed_providers_ids.add(admin.getStoreId());
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
