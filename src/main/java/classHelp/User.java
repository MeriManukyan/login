package classHelp;

/**
 * Created by mery.manukyan on 10/9/2018.
 */
public class User {
    private String password;
    private String name;
    private int id;
    static private int addId = 1;

    public User(String name, String password) {
        id = addId;
        this.name = name;
        this.password = password;
        addId++;
    }

    public User() {
        name = "mm";
        password = "mm";
        id = -1;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getAddId() {
        return addId;
    }
}
