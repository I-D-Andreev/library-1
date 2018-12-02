import java.util.ArrayList;

/**
 * UserManager class.
 * This class manages all the users in the system.
 * @author Ivan Andreev
 */
public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
        this.selfPopulate();
    }

    private void selfPopulate() {
        // test data
        this.addUser(new NormalUser("Sian", "Pike", "sianspike",
                "07813931066", "", new Address("14 Bryn Y Mor Crescent",
                        "Swansea", "Wales", "SA14QT")));

        this.addUser(new Librarian("Joe", "Bloggs", "librarian1",
                "12345678", "", new Address("Somewhere", "Cardiff", "Wales",
                "AB12CD")));
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

    public void payFine(double amount, User user){
        if(!user.hasAdminAccess()){
            ((NormalUser) user).payFines(amount);
        }
    }

}
