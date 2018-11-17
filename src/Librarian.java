/**
 * This is used to make an account for a librarian
<<<<<<< HEAD
 * @author Christina Meggs
 * @version 0.1
 */
public class Librarian extends User {
	private String staffNumber;
	
	/**
	 * Creates a librarian account with the inputted information.
	 * @param staff The librarians staff number.
	 * @param first The librarians first name.
	 * @param last The librarians last name.
	 * @param user The librarians account username.
	 * @param phone The librarians phone number.
	 * @param image The librarians profile image.
	 * @param ad The librarians home address.
	 */		
	public Librarian(String staff, String first, String last, String user, String phone, String image, String ad) {
		super(first,last,user,phone,image,ad);
		setStaffNumber(staff);
	}
	
	/**
	 * Gets staff number of the librarian.
	 * @return staffNumber The librarians staff number.
	 */		
	public String getStaffNumber() {
		return staffNumber;
	}
	
	/**
	 * sets staff number of the librarian.
	 * @return staff The librarians new staff number.
	 */		
	public void setStaffNumber(String staff) {
		this.staffNumber = staff;
	}
	
	/**
	 * Checks whether librarian has admin access.
	 * @return true as librarians have admin access.
	 */		
	public boolean hasAdminAccess() {
		return true;
	}
	
	/**
	 * Gets the employment date of the librarian.
	 * @return Librarians employment date.
	 */	
	//needs to be completed, will be date class 
	public String getEmploymentDate() {
		return "date";
	}
=======
 *
 * @author Christina Meggs, Ivan Andreev
 */
public class Librarian extends User {
    private String staffNumber;

    /**
     * Creates a librarian account with the inputted information.
     *
     * @param staff The librarians staff number.
     * @param first The librarians first name.
     * @param last  The librarians last name.
     * @param user  The librarians account username.
     * @param phone The librarians phone number.
     * @param image The librarians profile image.
     * @param ad    The librarians home address.
     */
    public Librarian(String staff, String first, String last, String user, String phone, String image, String ad) {
        super(first, last, user, phone, image, ad);
        this.setStaffNumber(staff);
    }

    /**
     * Gets staff number of the librarian.
     *
     * @return staffNumber The librarians staff number.
     */
    public String getStaffNumber() {
        return this.staffNumber;
    }

    /**
     * Sets the staff number of the librarian.
     *
     */
    private void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    /**
     * Checks whether librarian has admin access.
     *
     * @return True as librarians always have admin access.
     */
    public boolean hasAdminAccess() {
        return true;
    }

    /**
     * Gets the employment date of the librarian.
     *
     * @return Librarian's employment date.
     */
    //needs to be completed, will be date class
    public String getEmploymentDate() {
        return "date";
    }
>>>>>>> ea95d1945fafc8b632bd78f7bf1cfe6b3d9741d2
}