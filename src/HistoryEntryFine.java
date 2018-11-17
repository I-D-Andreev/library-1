import java.util.Date;

/**
 * Models a fine type of history entry.
 */
public class HistoryEntryFine extends HistoryEntryMoneyTransaction {

    /**
     * The item that is overdue and caused the fine.
     */
    private String item; // should be Copy type

    /**
     * The number of days the item was overdue.
     */
    private int daysOverdue;


    public HistoryEntryFine(Date date, double amount, int daysOverdue, String item) {
        super(date, amount);
        this.daysOverdue = daysOverdue;
        this.item = item;
    }


    public int getDaysOverdue() {
        return daysOverdue;
    }

//    public Copy getCopy() {
//        return item;
//    }
}
