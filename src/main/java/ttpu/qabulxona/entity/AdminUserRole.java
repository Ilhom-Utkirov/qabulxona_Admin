package ttpu.qabulxona.entity;

import org.hibernate.annotations.Type;
import ttpu.qabulxona.constants.UserRoles;

import javax.persistence.*;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Entity
@Table(name = "admin_user_role")
public class AdminUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AdminUser adminUser;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private Boolean enabled;

    public AdminUserRole(){}

    public AdminUserRole(UserRoles userRoles, AdminUser adminUser){
        this.role = userRoles;
        this.adminUser = adminUser;
        this.enabled = true;
        this.version = 1L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
