package ttpu.qabulxona.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registered_date;

    @OneToMany(mappedBy = "adminUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserAndAdmin> adminUser;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "adminUser", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<AdminUserRole> roles;



    public AdminUser(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean exists(){
        return this.id != null;
    }

    public void merge(AdminUser other){
        this.id = other.id != null ? other.id : this.id;
        this.name = other.name != null ? other.name : this.name;
        this.username = other.username != null ? other.username : this.username;
        this.password = other.password != null ? other.password : this.password;
        this.registered_date = other.registered_date != null ? other.registered_date : this.registered_date;
        this.phoneNumber = other.phoneNumber != null ? other.phoneNumber : this.phoneNumber;
        this.surname = other.surname != null ? other.surname : this.surname;
        this.enabled = other.enabled != null ? other.enabled : this.enabled;
    }

    public void addRole(AdminUserRole role) {
        role.setAdminUser(this);
        if (roles == null) {
            roles = new HashSet<>();
        }
        if (!roles.contains(role)) {
            roles.add(role);
        }
    }
    public Set<AdminUserRole> getRoles() {
        return roles;
    }

    public Set<UserAndAdmin> getProviders() {
        return adminUser;
    }

    public Set<UserAndAdmin> getAllProviders() {
        return adminUser;
    }
    public void setRoles(Set<AdminUserRole> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered_date() {
        return registered_date;
    }

    public void setRegistered_date(Date registered_date) {
        this.registered_date = registered_date;
    }
}
