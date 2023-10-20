import java.util.HashMap;
import java.util.Map;

public class User {
    public static Map<String, User_mess> ADMIN_USERS = new HashMap<>();
    public static Map<String, User_mess> COMMON_USERS = new HashMap<>();
    static {
        //adminers
        User_mess admin1 = new User_mess("m1","m1");
        User_mess admin2 = new User_mess("m2","m2");
        ADMIN_USERS.put(admin1.getUsername(), admin1);
        ADMIN_USERS.put(admin2.getUsername(), admin2);
        //commons
        User_mess com1 = new User_mess("p1","p1");
        User_mess com2 = new User_mess("p2","p2");
        User_mess com3 = new User_mess("p3","p3");
        COMMON_USERS.put(com1.getUsername(),com1);
        COMMON_USERS.put(com2.getUsername(),com2);
        COMMON_USERS.put(com3.getUsername(),com3);
    }
}
