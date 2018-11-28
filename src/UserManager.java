import java.util.ArrayList;

/**
 * UserManager class.
 * This class manages all the users in the system.
 */
public class UserManager {
    ArrayList<User> users = new ArrayList<>();

    public UserManager() {
        this.selfPopulate();
    }

    private void selfPopulate() {

    }

    public void save() {

    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void editUser(User user, User newUser){
        // needs to go through attributes 1 by 1
        // and change whatever is different
    }

    public void removeUser(User user){
        this.users.remove(user);
    }

}
