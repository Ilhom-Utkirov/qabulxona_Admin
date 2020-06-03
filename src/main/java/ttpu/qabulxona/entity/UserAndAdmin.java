package ttpu.qabulxona.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */
@Entity
@Table(name = "user_and_admin")
public class UserAndAdmin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn
    private AdminUser adminUser;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "region_code")
    private String regionCode;

    public UserAndAdmin() {
        regionCode = "0";
    }

    public UserAndAdmin(int StoreId, String RegionCode) {
        storeId = StoreId;
        regionCode = RegionCode;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
