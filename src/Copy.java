import java.util.Date;

/** Class to model a Copy of a resource.
 *
 * @author Kleanthis Liontis, Ivan Andreev.
 */
public class Copy {

    /**
     * The unique ID of each copy
     */
    private String uniqueCopyID;

    /**
     * The resource this copy is a copy of.
     */
    private Resource copyOf;

    /**
     * The copy manager of this copy.
     */
    private CopyManager copysManager;

    /**
     * Who has borrowed this copy.
     */
    private User borrowedBy;

    /**
     * Who is this copy reserved for.
     */
    private User reservedFor;

    /**
     * The loan duration of this copy in days.
     */
    private int loanDurationInDays;

    /**
     * When this copy was borrowed.
     */
    private Date borrowedOn;

    /**
     * When this copy is expected to be returned to back to library.
     */
    private Date dueDate;

    /**
     * The history on how many times this copy was loaned, when and by who.
     */
    private History loanHistory;

    /**
     * The next ID of a copy.
     */
    private static int nextId;

    /**
     * The constructor of a Copy.
     *
     * @param loanDurationInDays The loan duration in days of the copy.
     * @param copysManager The copy manager of the copy.
     */
    public Copy(int loanDurationInDays, CopyManager copysManager) {

        this.copysManager = copysManager;
        this.copyOf = copysManager.getCopyManagerOf();
        this.loanDurationInDays = loanDurationInDays;
        this.loanHistory = new History();
        this.setUniqueCopyID();
        this.nullifyValues();
    }

    /**
     * Gets the unique ID of the copy.
     * @return uniqueCopyID The unique copy of the copy.
     */
    public String getUniqueCopyID() {
        return uniqueCopyID;
    }

    /**
     *Gets the user this copy was borrowed by.
     * @return borrowedBy The user that borrowed the copy.
     */
    public User getBorrowedBy() {
        return borrowedBy;
    }

    /**
     * Sets the user that borrowed this copy.
     * @param borrowedBy The new user that borrowed the copy
     */
    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    /**
     * Gets the loan duration in days of the copy.
     * @return loanDurationInDays The loan duration in days of the copy.
     */
    public int getLoanDurationInDays() {
        return loanDurationInDays;
    }

    /**
     * Sets the loan duration in days of the copy.
     * @param loanDurationInDays The new load duration in days of the copy.
     */
    public void setLoanDurationInDays(int loanDurationInDays) {
        this.loanDurationInDays = loanDurationInDays;
    }

    /**
     * Gets the due date of the copy.
     * @return dueDate The date the copy is due.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date for the Copy
     */
    // TODO: test this method
    public void setDueDate() {
        // 3600 seconds in an hour, 24 hours a day, multiplied by 1000 to convert to milliseconds
        final long oneDayInMilliseconds = 3600 * 24 * 1000;

        // get the current date and add one day, to get the date tomorrow
        Date tomorrowDate = new Date();
        tomorrowDate.setTime(tomorrowDate.getTime() + oneDayInMilliseconds);

        //add the loan duration to the date the copy was borrowed
        // to get the other possible due date
        Date dueDateLoan = new Date(borrowedOn.getTime());
        dueDateLoan.setTime(dueDateLoan.getTime() + loanDurationInDays * oneDayInMilliseconds);

        // The due date should be the bigger of the two
        this.dueDate = (tomorrowDate.compareTo(dueDateLoan) == 1) ? tomorrowDate : dueDateLoan;

    }

    /**
     * Gets the loan history of the copy.
     * @return loanHistory The history of loaning of the copy.
     */
    public History getLoanHistory() {
        return loanHistory;
    }

    /**
     * Gets the date the copy was borrowed on.
     * @return borrowedOn The date the copy was borrowed on.
     */
    public Date getBorrowedOn() {
        return this.borrowedOn;
    }

    /**
     *Sets the day the copy was borrowed on.
     * @param borrowedOn The new date the copy was borrowed on.
     */
    public void setBorrowedOn(Date borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    /**
     * Gets the user the copy is reserved for.
     * @return reservedFor The user this copy was reserved for.
     */
    public User getReservedFor() {
        return this.reservedFor;
    }

    /**
     * Sets the user this copy is reserved for.
     * @param user The new user this copy is reserved for.
     */
    public void setReservedFor(User user) {
        this.reservedFor = user;
    }

    /**
     * Gets if the copy is available.
     * @return True if the copy is not borrowed and not reserved for a user,
     * False otherwise.
     */
    public boolean isAvailable() {
        return this.borrowedBy == null && this.reservedFor == null;
    }

    /**
     * Gets if the book should be returned.
     * @return True if the book has a due date,false otherwise.
     */
    public boolean shouldBeReturned() {
        return this.dueDate != null;
    }

    /**
     * Method to reset a copy to null values after it is returned.
     */
    private void nullifyValues() {
        this.borrowedBy = null;
        this.reservedFor = null;
        this.borrowedOn = null;
        this.dueDate = null;
    }

    /**
     * Gets the resource this copy is a copy of.
     * @return copyOf The resource this copy is a copy of.
     */
    public Resource getCopyOf() {
        return copyOf;
    }

    /**
     * Method that goes through what happens when a copy has just been returned.
     */
    public void returnCopy(){
        nullifyValues();
        NormalUser byUser = (NormalUser)this.borrowedBy;

        this.loanHistory.addEntry(new HistoryEntryItemTransaction(new Date(), false, byUser));
        byUser.getBorrowedCopies().remove(this);

        if(shouldBeFined()){
            giveFineToUser(byUser);
        }

        // Notify the copy's copy manager that a new copy is available.
        this.copyOf.getCopyManager().newAvailableCopyEvent();
    }


    private boolean shouldBeFined(){
        Date today = new Date();
        // If the item is overdue, the user should be fined.
        return (today.compareTo(this.dueDate) == 1);
    }

    /**
     * Sets a fine to a user,also update copy's history with this new fined user
     * @param user The user to be fined
     */
    private void giveFineToUser(NormalUser user) {
        Date today = new Date();
        // 3600 seconds in an hour, 24 hours a day, multiplied by 1000 to convert to milliseconds
        final long oneDayInMilliseconds = 3600 * 24 * 1000;

        long numberOfDaysOverdue = (today.getTime() - this.dueDate.getTime()) / oneDayInMilliseconds ;

        double fineAmount = Math.min(this.copyOf.getMaxFineAmount(),
                this.copyOf.getLateReturnFinePerDay() * numberOfDaysOverdue);

        user.giveFine(fineAmount);
        user.getTransactionHistory().addEntry(new HistoryEntryFine(today, fineAmount,
                (int)numberOfDaysOverdue, this));
    }

    /**
     * Sets the user this copy is loaned to,also update copy's history with this new loan.
     * @param toUser User the copy is loaned to.
     */
    public void loanCopyTo(NormalUser toUser){
        this.borrowedOn = new Date();
        this.borrowedBy = toUser;
        this.loanHistory.addEntry(new HistoryEntryItemTransaction(borrowedOn, true, toUser));
        toUser.getBorrowedCopies().add(this);
    }

    /**
     * Sets the uniqueCopyID of this copy.
     */
    private void setUniqueCopyID() {
        this.uniqueCopyID = this.copyOf.getUniqueID() + nextId;
        nextId++;
    }

    /**
     * todo comment this method
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Copy)) return false;
        Copy o = (Copy) obj;
        return o.getUniqueCopyID().equals(this.getUniqueCopyID());
    }

}
