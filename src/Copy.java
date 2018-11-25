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

    private void setUniqueCopyID() {
        this.uniqueCopyID = this.copyOf.getUniqueID() + nextId;
        nextId++;
    }
}
