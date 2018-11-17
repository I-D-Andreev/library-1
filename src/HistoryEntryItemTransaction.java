import java.util.Date;

public class HistoryEntryItemTransaction extends HistoryEntry {
    private boolean isBorrowed;
    private String borrowedBy; // should be User

    public HistoryEntryItemTransaction(Date date, boolean isBorrowed, String borrowedByUser) {
        super(date);
        this.isBorrowed = isBorrowed;
        this.borrowedBy = borrowedByUser;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

//    public User getBorrowedBy() {
//        return borrowedBy;
//    }
}
