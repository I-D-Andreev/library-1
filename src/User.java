/**
<<<<<<< HEAD
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
     * @param firstName The user's first name.
     * @param lastName  The user's last name.
     * @param user      The user's account username.
     * @param phone     The user's phone number.
     * @param imagePath The user's profile image.
     * @param address   The user's home address.
     */
    public User(String firstName, String lastName, String user, String phone, String imagePath, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = user;
        this.phoneNumber = phone;
        this.profileImagePath = imagePath;
        this.address = address;
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
     * @return lastName User's last name.
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
     * @return username The user's account username.
     */
    public String getUsername() {
        return username;
    }


    /**
     * Gets the user's phone number.
     *
     * @return phoneNumber The user's phone number.
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
     * Finds out if a phone number is valid.
     *
     * @return valid True if valid, false otherwise.
     */
    private boolean checkValidPhoneNumber() {
        return true;
    }

    /**
     * Gets the user's address.
     *
     * @return address The user's address.
     */
    //Instead of string will be address type when class is created
    public String getAddress() {
        return address;
    }

    /**
     * Sets the user's address.
     *
     * @param address The new address of the user.
     */
    //Instead of string will be address type when class is created
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the path to the user's profile image.
     *
     * @return profileImage The path to the user's profile image.
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
    public String getAccountCreationDate() {
        //will do a date type of the current days date
        return "16-11-2018";
    }

    /**
     * Says whether the user has admin access.
     */
    abstract boolean hasAdminAccess();
=======
 * This is an abstract class used as the base to create all types of users
 * @author Christina Meggs
 * @version 0.1
 */
public abstract class User {
	private String id; 
	private String firstName;
	private String lastName;
	private String username;
	private String phoneNumber;
	private String profileImage; //set as String for now until class been created 
	private String address; //set as String for now until Address class been created 
	
	/**
	 * Creates a user profile with the basic information within all types of users
	 * @param first The users first name.
	 * @param last The users last name.
	 * @param user The users account username.
	 * @param phone The users phone number.
	 * @param image The users profile image.
	 * @param ad The users home address.
	 */	
	public User(String first, String last, String user, String phone, String image, String ad) {
		this.firstName = first;
		this.lastName = last;
		this.username = user;
		this.phoneNumber = phone;
		this.profileImage = image;
		this.address = ad;
	}
	
	/**
	 * Gets user first name.
	 * @return firstName User's first name.
	 */	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets user first name.
	 * @param first The users new first name.
	 */		
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	/**
	 * Gets user last name.
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
	 * Gets the users account username.
	 * @return username Username of users account.
	 */		
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the users account username.
	 * @param user The new username for the account.
	 */		
	public void setUsername(String user) {
		this.username = user;
	}
	
	/**
	 * Gets the users phone number.
	 * @return phoneNumber the users phone number.
	 */		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the users phone number.
	 * @param phone The users new phone number.
	 */		
	public void setPhoneNumber(String phone) {
		this.phoneNumber = phone;
	}
	
	/**
	 * Finds out if phone number is valid.
	 * @return valid Whether the phone number is valid or not.
	 */		
	//Is in the UML but no class for phone number, not sure how to check it
	private boolean checkValidPhoneNumber() {
		valid == true;
		return valid; 
	}
	
	/**
	 * Gets the users address.
	 * @return address The users address.
	 */		
	//Instead of string will be address type when class is created 
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the users address.
	 * @param ad The new address of the user.
	 */		
	//Instead of string will be address type when class is created	
	public void setAddress(String ad) {
		this.address = ad;
	}
	
	/**
	 * Gets the users profile image.
	 * @return profileImage The users profile image.
	 */		
	//Instead of string will be profile image type when class is created 	
	public String getProfileImage() {
		return profileImage;
	}
	
	/**
	 * Sets the users profile image.
	 * @param image The users new profile image.
	 */		
	//Instead of string will be profile image type when class is created		
	public void setProfileImage(String image) {
		this.profileImage = image;
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
	 * Abstract so will be overridden.
	 */		
	abstract boolean hasAdminAccess();
>>>>>>> 0d1b7f407c62fcc32833c4d96148cc36dc81d5ec
}