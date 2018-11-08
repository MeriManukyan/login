package classHelp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class UserService {
    public static List<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User());
    }

    public static boolean isValid(String name, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidKey(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<User> getUserFromName(String name) {
        ArrayList<User> usersCurrent = new ArrayList<>();
        for (User user : users) {
            if (!user.getName().equals(name)) {
                usersCurrent.add(user);
            }
        }
        return usersCurrent;
    }
}


