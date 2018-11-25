import java.time.LocalDateTime;
import java.util.Date;

public class Copy {


    private String uniqueCopyID;
    private Resource copyOf;

    private User borrowedBy;
    private User reservedFor;

    private int loanDurationInDays;
    private Date borrowedOn;
    private Date dueDate;

    private History loanHistory;
    private static int nextId;

    public Copy(int loanDurationInDays, Resource copyOf) {

        this.copyOf = copyOf;
        this.loanDurationInDays = loanDurationInDays;
        this.loanHistory = new History();
        this.setUniqueCopyID();

        this.nullifyValues();
    }

    public String getUniqueCopyID() {
        return uniqueCopyID;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public int getLoanDurationInDays() {
        return loanDurationInDays;
    }

    public void setLoanDurationInDays(int loanDurationInDays) {
        this.loanDurationInDays = loanDurationInDays;
    }


    public Date getDueDate() {
        return dueDate;
    }

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

    public History getLoanHistory() {
        return loanHistory;
    }


    public Date getBorrowedOn() {
        return this.borrowedOn;
    }

    public void setBorrowedOn(Date borrowedOn) {
        this.borrowedOn = borrowedOn;
    }

    public User getReservedFor() {
        return this.reservedFor;
    }

    public void setReservedFor(User user) {
        this.reservedFor = user;
    }


    public boolean isAvailable() {
        return this.borrowedBy == null && this.reservedFor == null;
    }


    public boolean shouldBeReturned() {
        return this.dueDate != null;
    }

    private void nullifyValues() {
        this.borrowedBy = null;
        this.reservedFor = null;
        this.borrowedOn = null;
        this.dueDate = null;
    }

    public Resource getCopyOf() {
        return copyOf;
    }

    // What happens when a copy has just been returned.
    public void returned(NormalUser byUser){
        nullifyValues();

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

    public void loanCopyTo(NormalUser toUser){
        this.borrowedOn = new Date();
        this.borrowedBy = toUser;
        this.loanHistory.addEntry(new HistoryEntryItemTransaction(borrowedOn, true, toUser));
        toUser.getBorrowedCopies().add(this);
    }

    private void setUniqueCopyID() {
        this.uniqueCopyID = this.copyOf.getUniqueID() + nextId;
        nextId++;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Copy)) return false;
        Copy o = (Copy) obj;
        return o.getUniqueCopyID().equals(this.getUniqueCopyID());
    }

}
