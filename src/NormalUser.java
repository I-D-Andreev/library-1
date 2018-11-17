/**
 * This is used to make an account for a normal user
 *
 * @author Christina Meggs, Ivan ANdreev
 */
public class NormalUser extends User {
    private double balance;

    /**
     * Creates a normal users account with the inputted information.
     *
     * @param firstName        The users first name.
     * @param lastName         The users last name.
     * @param username         The users account username.
     * @param phoneNumber      The users phone number.
     * @param profileImagePath The users profile image.
     * @param address          The users home address.
     */
    public NormalUser(String firstName, String lastName, String username, String phoneNumber, String profileImagePath, String address) {
        super(firstName, lastName, username, phoneNumber, profileImagePath, address);
        this.balance = 0;
    }


    /**
     * Gets the user's account balance.
     *
     * @return balance The user's account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gives the user a fine.
     * Also adjusts their account balance.
     *
     * @param amount The amount of the fine.
     */
    //need to be done through a librarian?
    public void giveFine(double amount) {
    }

    /**
     * Pays off fine(s).
     * Also adjusts the account balance accordingly.
     *
     * @param amount The amount the user is paying off.
     */
    //why boolean? needs to be done through a librarian?
    public boolean payFines(double amount) {
        return true;
    }

    /**
     * Checks if the user has admin access.
     *
     * @return false Normal users don't have admin access.
     */
    public boolean hasAdminAccess() {
        return false;
    }

    /**
     * Gets the transaction history of the user.
     *
     * @return Transaction history of the user.
     */
    //will be history instead string, done just so compiles
    public String getTransactionHistory() {
        return "";
    }

    /**
     * Says if a user can borrow copies.
     *
     * @return true if a user can borrow a copy, otherwise - false.
     */
    public boolean canBorrowCopy() {
        return false;
    }

    /**
     * Gets the number of books borrowed by the users inbetween dates.
     *
     * @param fromDate The start date.
     * @param toDate   The end date.
     * @return Number of books borrowed between the start and the end date.
     */
    //needs to be completed, string will be Date
    public int getNumberOfBooksBorrowedBetween(String fromDate, String toDate) {
        return 0;
    }
}