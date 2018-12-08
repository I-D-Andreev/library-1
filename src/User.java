import java.io.*;
import java.util.Date;

/**
 * This is an abstract class used as the base to create all types of users.
 *
 * @author Christina Meggs, Ivan Andreev
 */
public abstract class User implements Serializable {
    private static int nextID = 0;
    private final String username;

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profileImagePath;
    private Date creationDate;
    private Address address;

    /**
     * Creates a user profile with the basic information within all types of users.
     *
     * @param firstName The user's first name.
     * @param lastName  The user's last name.
     * @param user      The user's account username.
     * @param phone     The user's phone number.
     * @param imagePath The user's profile image.
     * @param address   The user's home address.
     */
    public User(String firstName, String lastName, String user, String phone, String imagePath, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = user;
        this.phoneNumber = phone;
        this.profileImagePath = imagePath;
        this.address = address;

        // set the creation date to the current date
        this.creationDate = new Date();

        this.setID();
    }

    /**
     * Gets the user's id.
     *
     * @return The user's id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the user's first name.
     *
     * @return The user's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName The user's new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets user's last name.
     *
     * @return the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets user's last name.
     *
     * @param lastName The user's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's account username.
     *
     * @return The user's account username.
     */
    public String getUsername() {
        return username;
    }


    /**
     * Gets the user's phone number.
     *
     * @return The user's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phoneNumber The user's new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Gets the user's address.
     *
     * @return The user's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     *
     * @param address The new address of the user.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets the path to the user's profile image.
     *
     * @return The path to the user's profile image.
     */
    //Instead of string will be profile image type when class is created
    public String getProfileImagePath() {
        return profileImagePath;
    }

    /**
     * Sets the user's new profile image path.
     *
     * @param imagePath The user's new profile image path.
     */
    //Instead of string will be profile image type when class is created
    public void setProfileImagePath(String imagePath) {
        this.profileImagePath = imagePath;
    }

    /**
     * Gets the date when the account was created.
     *
     * @return The creation date of the account.
     */
    public Date getAccountCreationDate() {
        return this.creationDate;
    }

    /**
     * Says whether the user has admin access.
     */
    abstract boolean hasAdminAccess();

    private void setID() {
        this.id = this.firstName + "-" + nextID;
        nextID++;
    }

    /**
     * Get the next ID variable.
     *
     * @return The next ID variable.
     */
    public static int getNextID() {
        return nextID;
    }

    /**
     * Sets the next ID variable.
     *
     * @param nextID The new next ID variable.
     */
    public static void setNextID(int nextID) {
        User.nextID = nextID;
    }

    /**
     * Checks that the user is an object of type user and gets its ID.
     *
     * @param obj The user to be checked.
     * @return The user's unique ID if true,false otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof User)) return false;
        User o = (User) obj;
        return o.getId().equals(this.getId());
    }
}