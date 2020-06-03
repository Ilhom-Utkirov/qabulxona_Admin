package ttpu.qabulxona.constants;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Mr_Inspiration
 * @since 19.01.2020
 */

public enum UserRoles {
    CAN_SEE_LIST_OF_APPEAL(0, "Murojaatlarni ko'ra olish"),
    CAN_EDIT_ADMIN_USERS(1,"Adminlarni o'zgartirish"),
    CAN_ANSWER_TO_APPEALS(2,"Murajaatlarga javob bra olish");

    private final String Label;
    private final Integer Id;

    UserRoles(Integer id, String label) {
        this.Label = label;
        this.Id = id;
    }
    private static final Map<Integer,UserRoles> map;
    static {
        map = new HashMap<Integer,UserRoles>();
        for (UserRoles r : UserRoles.values()) {
            map.put(r.getId(), r);
        }
    }
    public static UserRoles findById(int Id) {
        return map.get(Id);
    }
    public String getLabel() {
        return this.Label;
    }
    public Integer getId() {
        return this.Id;
    }
}
