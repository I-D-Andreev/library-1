import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Copy {

    //asdasojdashddasojdasojdoasjosaijd
    private String uniqueCopyID;
    private Resource copyOf;
    private User borrowedBy;
    private User reservedFor;
    private int loanDurationInDays;
    //private Date borrowedOn;
    //private Date dueDate;
    private History loanHistory;
    private static int nextId;

    public Copy(String uniqueCopyID, Resource copyOf){

        this.uniqueCopyID=uniqueCopyID;
        this.copyOf=copyOf;
    }

    public String getUniqueCopyID() {
        return uniqueCopyID;
    }

    public void setUniqueCopyID(String uniqueCopyID) {
        this.uniqueCopyID = uniqueCopyID;
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
    /*
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    */
    public History getLoanHistory() {
        return loanHistory;
    }

    /*
    public Date getBorrowedOn(){
        return this.borrowedOn;
    }

    public void setBorrowedOn(Date borrowedOn) {
        this.borrowedOn = borrowedOn;
    }
    */
    public User getReservedFor(){
        return this.reservedFor;
    }

    public void setReservedFor(User user){
        this.reservedFor=user;
    }

    public static int getNextId() {
        return nextId;
    }

    public boolean isAvailable(){
        if (this.borrowedBy != null) {
            return false;
        }else return true;
    }

    /* todo Need Date class to be finished to do
        else use API>?

    public boolean shouldBeReturned(){

        if (this.dueDate >= (this.borrowedOn +)){
            return true;
        }else return false;
    }*/
}
