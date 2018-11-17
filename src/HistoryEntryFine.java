import java.util.Date;

/**
 * Models a fine type of history entry.
 */
public class HistoryEntryFine extends HistoryEntryMoneyTransaction {
    private int daysOverdue;
    private String copy; // should be Copy type

    public HistoryEntryFine(Date date, double amount, int daysOverdue, String copy) {
        super(date, amount);
        this.daysOverdue = daysOverdue;
        this.copy = copy;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

//    public Copy getCopy() {
//        return copy;
//    }
}
