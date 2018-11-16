/**
 * This is an abstract class used as the base to create all types of users.
 *
 * @author Christina Meggs, Ivan Andreev
 */
public abstract class User {
    private final String username;

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profileImagePath; //set as String for now until class been created
    private String address; //set as String for now until Address class been created

    /**
     * Creates a user profile with the basic information within all types of users.
     *
     * @param first The user's first name.
     * @param last  The user's last name.
     * @param user  The user's account username.
     * @param phone The user's phone number.
     * @param imagePath The user's profile image.
     * @param ad    The user's home address.
     */
    public User(String first, String last, String user, String phone, String imagePath, String ad) {
        this.firstName = first;
        this.lastName = last;
        this.username = user;
        this.phoneNumber = phone;
        this.profileImagePath = imagePath;
        this.address = ad;
    }

    /**
     * Gets the user's first name.
     *
     * @return firstName User's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets user first name.
     *
     * @param first The users new first name.
     */
    public void setFirstName(String first) {
        this.firstName = first;
    }

    /**
     * Gets user's last name.
     * @return lastName User's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets user last name.
     * @param last The users new last name.
     */
    public void setLastName(String last) {
        this.lastName = last;
    }

    /**
     * Gets the user's account username.
     * @return username Username of users account.
     */
    public String getUsername() {
        return username;
    }


    /**
     * Gets the users phone number.
     *
     * @return phoneNumber the users phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the user's phone number.
     * @param phone The users new phone number.
     */
    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    /**
     * Finds out if a phone number is valid.
     * @return valid Whether the phone number is valid or not.
     */
    private boolean checkValidPhoneNumber() {
        return true;
    }

    /**
     * Gets the user's address.
     * @return address The user's address.
     */
    //Instead of string will be address type when class is created
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     * @param adddress The new address of the user.
     */
    //Instead of string will be address type when class is created
    public void setAddress(String adddress) {
        this.address = adddress;
    }

    /**
     * Gets the path to the user's profile image.
     * @return profileImage The path to the user's profile image.
     */
    //Instead of string will be profile image type when class is created
    public String getProfileImagePath() {
        return profileImagePath;
    }

    /**
     * Sets the user's profile image.
     * @param imagePath The users new profile image.
     */
    //Instead of string will be profile image type when class is created
    public void setProfileImagePath(String imagePath) {
        this.profileImagePath = imagePath;
    }

    /**
     * Gets the date of when the account was created.
     * @return The creation date of account.
     */
    public String getAccountCreationDate() {
        //will do a date type of the current days date
        return "16-11-2018";
    }

    /**
     * Retrieves if the user has admin access.
     */
    abstract boolean hasAdminAccess();
}