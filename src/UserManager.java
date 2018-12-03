import java.io.*;
import java.util.ArrayList;

/**
 * UserManager class.
 * This class manages all the users in the system.
 *
 * @author Ivan Andreev
 */
public class UserManager implements Serializable {
    private ArrayList<User> users;

    public UserManager() {
        users = new ArrayList<>();
        // this.selfPopulate1();
    }


    public void save() {
        File file = fileToReadWrite();

        try {
            // file writer
            // every time overwrite the file instead of just appending
            FileOutputStream fileOut = new FileOutputStream(file, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // save the object to the file
            out.writeObject(users);

            // close the file writer
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Problem creating a file writer.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Problem writing to file.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Successfully written in file.");
    }

    // should be private / public only for testing purposes
    public void selfPopulate() {
        // Get a file to read from or create it if it doesn't exist.
        File file = fileToReadWrite();

        try {
            // file reader
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // read the object in the file
            ArrayList<User> readUsers = (ArrayList<User>) in.readObject();

            // close the reader
            in.close();
            fileIn.close();

            // assign the variable we just read
            this.users = readUsers;

        } catch (IOException e) {
            System.out.println("Couldn't access file to read from.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Problem reading from file.");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Successfully read user from file.");
    }

    // test data
    public void selfPopulate1() {
        this.addUser(new NormalUser("Sian", "Pike", "sianspike",
                "07813931066", "", new Address("14 Bryn Y Mor Crescent",
                "Swansea", "Wales", "SA14QT")));

        this.addUser(new Librarian("Joe", "Bloggs", "librarian1",
                "12345678", "", new Address("Somewhere", "Cardiff", "Wales",
                "AB12CD")));
    }

    // Get a file to read/write or create it if it doesn't exist.
    private File fileToReadWrite() {
        File file = null;
        try {
            file = new File("src/resources/users.ser");
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Problem accessing file.");
            e.printStackTrace();
            System.exit(0);
        }
        return file;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void editUser(User user, User newUser) {
        // needs to go through attributes 1 by 1
        // and change whatever is different
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void removeUser(String userId) {
        this.users.remove(this.getUserById(userId));
    }

    public User getUserById(String userId) {
        User returnUser = null;
        for (User user : users) {
            if (user.getId().equals(userId)) {
                returnUser = user;
            }
        }
        return returnUser;
    }

    public User getUserByUsername(String username) {
        User returnUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                returnUser = user;
            }
        }

        return returnUser;
    }

    public ArrayList<User> getAllUsers() {
        return this.users;
    }

    public void payFine(double amount, User user) {
        if (!user.hasAdminAccess()) {
            ((NormalUser) user).payFines(amount);
        }
    }

}
