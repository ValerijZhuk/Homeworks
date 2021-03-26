package master;

import java.util.HashMap;
import java.util.Map;

public class UserList  {
    public static master.User findUser(String user){
        return (master.User)users.get(user);
    }

    public static boolean addUser(master.User user){
        boolean result = false;
        if ((!users.containsKey(user.getUser()))&&(user.getPassword()!=null)&&(!"".equals(user.getPassword()))){
            users.put(user.getUser(),user);
            result = true;
        }
        return result;
    }
    private static Map users = new HashMap();

}