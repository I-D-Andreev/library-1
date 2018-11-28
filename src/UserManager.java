import java.util.ArrayList;

/**
 * UserManager class.
 * This class manages all the users in the system.
 */
public class UserManager {
    ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
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

    public void removeUser(String userId){
        this.users.remove(this.getUserById(userId));
    }

    public User getUserById(String userId){
        User returnUser = null;
        for(User user: users){
            if(user.getId().equals(userId)){
                returnUser = user;
            }
        }
        return  returnUser;
    }

    public User getUserByUsername(String username){
        User returnUser = null;
        for(User user: users){
                if(user.getUsername().equals(username)){
                    returnUser = user;
                }
        }

        return  returnUser;
    }

    public ArrayList<User> getAllUsers() {
        return this.users;
    }

}
